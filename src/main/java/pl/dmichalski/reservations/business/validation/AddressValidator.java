package pl.dmichalski.reservations.business.validation;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Address;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import java.util.Optional;

@Component
public class AddressValidator extends ValidationSupport implements Validator<Address> {

    @Override
    public Optional<ValidationError> validate(Address address) {
        if (isNullOrEmptyString(address.getStreet()) ||
                isNullOrEmptyString(address.getHouseNumber()) ||
                isNullOrEmptyString(address.getFlatNumber()) ||
                isNullOrEmptyString(address.getCity()) ||
                isNullOrEmptyString(address.getPostCode())) {
            return Optional.of(new ValidationError(ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        return Optional.empty();
    }

}
