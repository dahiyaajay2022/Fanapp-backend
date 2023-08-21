package ca.novascotia.digitalservice.fanapp.validations;

import ca.novascotia.digitalservice.fanapp.custominterface.ValidSpeed;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class SpeedConstraintValidator implements ConstraintValidator<ValidSpeed, Integer> {

    private final List<Integer> validSpeeds = Arrays.asList(0, 1, 2, 3);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return validSpeeds.contains(value);
    }
}
