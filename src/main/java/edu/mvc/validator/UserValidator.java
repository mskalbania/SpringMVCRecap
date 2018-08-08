package edu.mvc.validator;

import edu.mvc.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

public class UserValidator implements ConstraintValidator<ValidUser, User> {

    private static final String USER_NAME_FIELD = "userName";
    private static final String PASSWORD = "password";

    private static final String INVALID_USER_NAME_MESSAGE = "Invalid user name";
    private static final String INVALID_PASSWORD_MESSAGE = "Invalid password";
    private static final String INVALID_GENDER = "Invalid gender";
    private static final String INVALID_ROLE = "Invalid role";

    //LOG THIS OUT

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        final Map<String, String> constrainViolations = new HashMap<>();
        boolean valid = true;
        if (!isUserNameValid(user.getUserName())) {
            constrainViolations.put(USER_NAME_FIELD, INVALID_USER_NAME_MESSAGE);
            valid = false;
        }
        if(!isPasswordValid(user.getPassword())) {
            constrainViolations.put(PASSWORD, INVALID_PASSWORD_MESSAGE);
            valid = false;
        }
        if(!valid) {
            addConstrainViolation(constraintValidatorContext, constrainViolations);
        }
        return valid;
    }
    
    private boolean isUserNameValid(String userName) {
        if (userName != null) {
            userName = userName.trim();
            return !userName.isEmpty() && userName.length() >= 5
                    && userName.length() < 10 && !userName.matches(".*\\d+.*");
        } else {
            return false;
        }
    }
    
    private boolean isPasswordValid(String password) {
        if (password != null) {
            password = password.trim();
            return !password.isEmpty() && password.length() >= 5
                    && password.length() < 10 && !password.matches(".*[\\\\;':\",./?!@#$%&*()+=-].*");
        } else {
            return false;
        }
    }
    
    private void addConstrainViolation(final ConstraintValidatorContext ctx, final Map<String, String> constrainViolations) {
        ctx.disableDefaultConstraintViolation();
        for(final Map.Entry<String, String> entry : constrainViolations.entrySet()) {
            ctx.buildConstraintViolationWithTemplate(entry.getValue()).addPropertyNode(entry.getKey());
        }
    }
}
