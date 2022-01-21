package com.zipcar.orderservice.controller;

import com.zipcar.orderservice.dto.OrderRequest;
import com.zipcar.orderservice.dto.OrderResponse;
import com.zipcar.orderservice.exceptions.RecordNotFoundException;
import com.zipcar.orderservice.helper.OrderServiceHelper;
import com.zipcar.orderservice.model.Order;
import com.zipcar.orderservice.service.OrderService;
import com.zipcar.orderservice.utils.LogError;
import com.zipcar.orderservice.utils.Profile;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderServiceHelper orderServiceHelper;

    @Profile
    @LogError
    @SneakyThrows
    //@ApiOperation(value = "Description:This API fetch the list of order data in the Order table", response = Order[].class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrder(@RequestParam(value = "user_id", required = false) Long userId) {
        List<Order> list = new ArrayList<>();
        if (ObjectUtils.isEmpty(userId)) {
            list = orderService.getAllOrders();
        } else {
            list = orderService.getOrderByUserId(userId);
        }
        return new ResponseEntity<List<Order>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @Profile
    @LogError
    @SneakyThrows
    //@ApiOperation(value = "Description:This API fetch the order data by id in the Order table", response = Order.class)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Order entity = orderService.getOrderById(id);
        return new ResponseEntity<Order>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @Profile
    @LogError
    @SneakyThrows
    //@ApiOperation(value = "Description:This API save the OrderRequest data in the Order table", response = OrderResponse.class)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Validated OrderRequest orderRequest)
            throws RecordNotFoundException {
        Order order = orderService.generateNewOrder(orderRequest);
        return new ResponseEntity<OrderResponse>(orderServiceHelper.prepareResponse(order), new HttpHeaders(), HttpStatus.CREATED);
    }

    @Profile
    @LogError
    @SneakyThrows
    //@ApiOperation(value = "Description:This API delete of order data in the Order table", response = HttpStatus.class)
    @DeleteMapping("/{id}")
    public HttpStatus deleteOrderById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        //Validation can be applied here before deleting on the bass of the user.
        orderService.deleteOrderById(id);
        return HttpStatus.ACCEPTED;
    }
}
