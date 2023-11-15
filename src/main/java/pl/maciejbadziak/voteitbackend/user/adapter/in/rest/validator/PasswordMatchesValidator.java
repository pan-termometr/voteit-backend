package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.maciejbadziak.voteitbackend.user.domain.User;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        // implementation not needed
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        final User user = (User) obj;
        if (user.getPassword() == null || user.getMatchingPassword() == null) {
            return false;
        }
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
