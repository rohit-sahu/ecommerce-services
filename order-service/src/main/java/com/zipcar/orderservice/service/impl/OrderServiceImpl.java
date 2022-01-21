package com.zipcar.orderservice.service.impl;

import com.zipcar.orderservice.dto.OrderRequest;
import com.zipcar.orderservice.exceptions.RecordNotFoundException;
import com.zipcar.orderservice.helper.OrderServiceHelper;
import com.zipcar.orderservice.model.*;
import com.zipcar.orderservice.repository.AddressRepository;
import com.zipcar.orderservice.repository.CartRepository;
import com.zipcar.orderservice.repository.OrderRepository;
import com.zipcar.orderservice.repository.UserRepository;
import com.zipcar.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderServiceHelper orderServiceHelper;

    public List<Order> getAllOrders() {
        List<Order> orderList = repository.findAll();
        if (orderList.size() > 0) {
            return orderList;
        } else {
            return new ArrayList<Order>();
        }
    }

    public Order getOrderById(Long id) throws RecordNotFoundException {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RecordNotFoundException("No Order record exist for given id");
        }
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        //Validation can be applied here for the user id from the user-service microservices.
        Optional<List<Order>> orderList = repository.findOrderByAccountIdAndIsActive(userId, Boolean.TRUE);
        if (orderList.isPresent() && orderList.get().size() > 0) {
            return orderList.get();
        } else {
            return new ArrayList<Order>();
        }
    }

    @Override
    @Transactional
    public Order generateNewOrder(OrderRequest orderRequest) {
        if (!ObjectUtils.isEmpty(orderRequest)) {
            Long cartId = orderRequest.getCartId();
            Long userId = orderRequest.getUserId();
            //get the cart data from the cart microservices
            Optional<Cart> cartOptional = cartRepository.findById(cartId);
            //get the user data from the user microservices
            Optional<User> userOptional = userRepository.findById(userId);
            //get the address data from the user microservices
            Optional<Address> optionalAddress = addressRepository.findById(orderRequest.getShippingAddress());
            if (cartOptional.isPresent() && userOptional.isPresent() && optionalAddress.isPresent()) {
                Order order = orderServiceHelper.createOrderObject(orderRequest, cartOptional.get(), userOptional.get(),
                        optionalAddress.get());
                return repository.save(order);
            } else {
                throw new RecordNotFoundException("Record doesn't exist for given id");
            }
        }
        return null;
    }

    @PostConstruct
    public void initilizeAddress() {
        Address address = new Address();
        address.setAddressLine("ADFGHJK");
        address.setAddressType(Address.AddressType.CURRENT);
        address.setCity("lakhisarai");
        address.setCountry("INDIA");
        address.setLandmark("fghjkophg");
        address.setHouseNumber(123);
        address.setLongitude(56789d);
        address.setLongitude(9876D);
        address.setState("BIHAR");
        address.setStreet("eryuiokjh");
        address.setZipcode(new Zipcode("456789", "9567"));
        address.setUser(userRepository.findById(1L).get());
        addressRepository.save(address);
    }

    public void deleteOrderById(Long id) throws RecordNotFoundException {
        Optional<Order> order = repository.findById(id);
        if (order.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Order record exist for given id");
        }
    }
}
