package com.demo.nace.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class contains method which contains DB to Entity converter and vice versa
 */
@Converter
public class IntegerToLongConverter implements AttributeConverter< Long,
        Integer > {


    @Override
    public Integer convertToDatabaseColumn(Long aLong) {
        return aLong.intValue();
    }

    @Override
    public Long convertToEntityAttribute(Integer integer) {
        return Long.valueOf(integer);
    }
}
