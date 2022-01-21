package com.zipcar.orderservice.utils;

import com.zipcar.orderservice.model.Address;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<Address.AddressType, String> {

    @Override
    public String convertToDatabaseColumn(Address.AddressType addressType) {
        return addressType.getShortName();
    }

    @Override
    public Address.AddressType convertToEntityAttribute(String dbData) {
        return Address.AddressType.fromShortName(dbData);
    }
}
