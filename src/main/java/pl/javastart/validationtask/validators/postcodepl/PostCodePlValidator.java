package pl.javastart.validationtask.validators.postcodepl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostCodePlValidator implements ConstraintValidator<PostCodePl, String> {

    private String pattern;

    @Override
    public void initialize(PostCodePl constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        char[] tab = pattern.toCharArray();
        char[] postCodeTab = s.toCharArray();
        if (tab.length == postCodeTab.length) {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] == 'X' && postCodeTab[i] < '0' && postCodeTab[i] > '9') {
                    return false;
                } else if (tab[i] == '-' && postCodeTab[i] != '-') {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
