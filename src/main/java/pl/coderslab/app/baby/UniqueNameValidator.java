package pl.coderslab.app.baby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private BabyService babyService;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(babyService == null){
            return true;
        }

        return !babyService.isNameAlreadyInUse(value);
    }

}
