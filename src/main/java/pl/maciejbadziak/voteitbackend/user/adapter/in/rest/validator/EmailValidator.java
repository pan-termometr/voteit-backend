package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator
        implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[\\w-.]+@([\\w-]+\\.){0,30}+[\\w-]{2,4}$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        // implementation not needed
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        return (validateEmail(email));
    }

    private boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
