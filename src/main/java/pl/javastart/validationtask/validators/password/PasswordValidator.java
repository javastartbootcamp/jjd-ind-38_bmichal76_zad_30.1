package pl.javastart.validationtask.validators.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final List<Character> escapeChars = List.of('<', '(', '[', '{', '\\', '^', '-', '=', '$', '!', '|', ']', '}', ')', '?', '*', '+', '.', '>');

    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        char[] tab = s.toCharArray();
        boolean spec = false;
        boolean upper = false;
        boolean low = false;
        for (char c : tab) {
            if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isLowerCase(c)) {
                low = true;
            } else if (!escapeChars.stream()
                    .filter(character -> character.equals(c))
                    .collect(Collectors.toList()).isEmpty()) {
                spec = true;
            }
        }
        return spec && low && upper;
    }
}
