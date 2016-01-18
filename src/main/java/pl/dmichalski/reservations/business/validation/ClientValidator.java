package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.util.ConstMessages;

import java.util.Optional;

@Component
public class ClientValidator extends ValidationSupport implements Validator<Client> {

    private static final int PESEL_LENGTH = 11;

    @Override
    public Optional<ValidationError> validate(Client client) {
        if (isNullOrEmptyString(client.getName()) ||
                isNullOrEmptyString(client.getSurname()) ||
                isNullOrEmptyString(client.getPesel()) ||
                isNullOrEmptyString(client.getPhoneNumber()) ||
                isNullOrEmptyString(client.getEmail()) ||
                isNullValue(client.getAddress())) {
            return Optional.of(new ValidationError(ConstMessages.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (PESEL_LENGTH != client.getPesel().length()) {
            return Optional.of(new ValidationError(ConstMessages.ValidationMessages.PESEL_LENGTH_INCORRECT));
        }
        return Optional.empty();
    }

}