package mas.mp5.mas_final.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GroupCodeValidator.class)
public @interface ValidGroupCode {
    String message() default "Invalid format for groupCode - code format is XXXN where XXX is city shortcut and N is number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
