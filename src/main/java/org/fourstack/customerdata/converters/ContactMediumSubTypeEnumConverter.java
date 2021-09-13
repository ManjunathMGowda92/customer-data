package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.ContactMediumSubType;
import org.fourstack.customerdata.codetype.ContactMediumType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link ContactMediumSubType} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class ContactMediumSubTypeEnumConverter implements AttributeConverter<ContactMediumSubType, String> {
    @Override
    public String convertToDatabaseColumn(ContactMediumSubType contactMediumSubType) {
        if (contactMediumSubType == null)
            return null;

        return contactMediumSubType.name();
    }

    @Override
    public ContactMediumSubType convertToEntityAttribute(String str) {
        if (str == null)
            return null;

        return Stream.of(ContactMediumSubType.values())
                .filter(contactMediumSubType -> contactMediumSubType.name().equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
