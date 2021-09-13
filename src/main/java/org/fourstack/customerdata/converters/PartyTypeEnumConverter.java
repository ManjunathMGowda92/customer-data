package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.ContactMediumType;
import org.fourstack.customerdata.codetype.PartyType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link PartyType} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class PartyTypeEnumConverter implements AttributeConverter<PartyType, String> {
    @Override
    public String convertToDatabaseColumn(PartyType partyType) {
        if (partyType == null)
            return null;
        return partyType.name();
    }

    @Override
    public PartyType convertToEntityAttribute(String str) {
        if (str == null)
            return null;
        return Stream.of(PartyType.values())
                .filter(partyType -> partyType.name().equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
