package mas.mp5.mas_final.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mas.mp5.mas_final.model.Person;

/**
 * Validator for telephone in Person class
 */

public class PersonTelephoneValidator implements ConstraintValidator<ValidTelephone, Person> {


    @Override
    public void initialize(ValidTelephone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        return person.getTelephone().length() == 9 && person.getTelephone().matches("\\d{9}");
    }
}
