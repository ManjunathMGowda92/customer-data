package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.AccountStatus;
import org.fourstack.customerdata.codetype.ContactMediumType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link AccountStatus} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class AccountStatusEnumConverter implements AttributeConverter<AccountStatus, String> {
    @Override
    public String convertToDatabaseColumn(AccountStatus accountStatus) {
        if (accountStatus == null)
            return null;
        return accountStatus.name();
    }

    @Override
    public AccountStatus convertToEntityAttribute(String accountStatus) {
        if (accountStatus == null)
            return null;

        return Stream.of(AccountStatus.values())
                .filter(status -> status.name().equals(accountStatus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
