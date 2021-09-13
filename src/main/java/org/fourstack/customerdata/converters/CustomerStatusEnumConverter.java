package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.CustomerStatus;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link CustomerStatus} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class CustomerStatusEnumConverter implements AttributeConverter<CustomerStatus, String> {
    @Override
    public String convertToDatabaseColumn(CustomerStatus customerStatus) {
        if (customerStatus == null)
            return null;

        return customerStatus.name();
    }

    @Override
    public CustomerStatus convertToEntityAttribute(String str) {
        if (str == null)
            return null;
        return Stream.of(CustomerStatus.values())
                .filter(customerStatus -> customerStatus.name().equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
