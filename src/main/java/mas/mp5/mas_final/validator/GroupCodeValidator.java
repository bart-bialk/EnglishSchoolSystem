package mas.mp5.mas_final.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mas.mp5.mas_final.model.Group;

/**
 * Validator for group code in Group class
 */

public class GroupCodeValidator implements ConstraintValidator<ValidGroupCode, Group> {
    @Override
    public void initialize(ValidGroupCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Group group, ConstraintValidatorContext constraintValidatorContext) {
        return group.getGroupCode().matches("[A-Z]{3}\\d+");
    }
}
