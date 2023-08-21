package ca.novascotia.digitalservice.fanapp.custominterface;

import ca.novascotia.digitalservice.fanapp.validations.SpeedConstraintValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SpeedConstraintValidator.class)
public @interface ValidSpeed {
    String message() default "Invalid speed value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

