package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.CustomerSubType;
import org.fourstack.customerdata.codetype.CustomerType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link CustomerType} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class CustomerTypeEnumConverter implements AttributeConverter<CustomerType, String> {
    @Override
    public String convertToDatabaseColumn(CustomerType customerType) {
        if (customerType == null)
            return null;
        return customerType.name();
    }

    @Override
    public CustomerType convertToEntityAttribute(String str) {
        if (str == null)
            return null;
        return Stream.of(CustomerType.values())
                .filter(customerType -> customerType.name().equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
