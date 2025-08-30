package mas.mp5.mas_final.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonTelephoneValidator.class)
public @interface ValidTelephone {
    String message() default "Invalid format for telephone - number must be 9 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}