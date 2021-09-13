package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.ContactMediumType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link ContactMediumType} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class ContactMediumTypeEnumConverter implements AttributeConverter<ContactMediumType, String> {
    @Override
    public String convertToDatabaseColumn(ContactMediumType contactMediumType) {
        if (contactMediumType == null)
            return null;

        return contactMediumType.name();
    }

    @Override
    public ContactMediumType convertToEntityAttribute(String str) {
        if (str == null)
            return null;

        return Stream.of(ContactMediumType.values())
                .filter(contactMediumType -> contactMediumType.name().equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
