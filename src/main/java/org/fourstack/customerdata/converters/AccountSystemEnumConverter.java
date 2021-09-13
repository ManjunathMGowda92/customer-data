package org.fourstack.customerdata.converters;

import org.fourstack.customerdata.codetype.AccountSystem;
import org.fourstack.customerdata.codetype.ContactMediumType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * AttributeConverter class which converts the Enum {@link AccountSystem} to String value
 * and vice-versa. This helps in storing Base values (Integer, long, String etc..) into Database
 * without @Enumerated Enum support and convert back Base values to Enum.
 *
 * @author Manjunath HM
 */
@Component
@Converter(autoApply = true)
public class AccountSystemEnumConverter implements AttributeConverter<AccountSystem, String> {
    @Override
    public String convertToDatabaseColumn(AccountSystem accountSystem) {
        if (accountSystem == null)
            return null;
        return accountSystem.name();
    }

    @Override
    public AccountSystem convertToEntityAttribute(String account) {
        if (account == null)
            return null;

        return Stream.of(AccountSystem.values())
                .filter(acct -> acct.name().equals(account))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
