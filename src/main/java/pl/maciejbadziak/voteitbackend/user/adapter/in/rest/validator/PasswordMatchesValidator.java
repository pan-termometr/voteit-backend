package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.maciejbadziak.voteitbackend.user.domain.User;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        User user = (User) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
