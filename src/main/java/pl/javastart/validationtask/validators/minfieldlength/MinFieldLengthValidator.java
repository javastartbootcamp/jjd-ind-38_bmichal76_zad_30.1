package pl.javastart.validationtask.validators.minfieldlength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinFieldLengthValidator implements ConstraintValidator<MinFieldLength, String> {
    private int size;
    private static final String STR_SIZE_ONE = "pole music mieć conajmniej {size} znak";
    private static final String STR_SIZE_BETWEEN_TWO_AND_FOUR = "pole musi mieć conajmniej {size} znaki";
    private static final String STR_SIZE_MORE_THEN_FOUR = "pole musi mieć conajmniej {size} znaków";

    @Override
    public void initialize(MinFieldLength constraintAnnotation) {
        int setSize = constraintAnnotation.size();
        if (setSize > 0) {
            this.size = constraintAnnotation.size();
        } else {
            throw new IllegalArgumentException("Annotation argument for MinFieldLength is incorrect");
        }
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext cvc) {
        if (str.length() >= size) {
            return true;
        } else {
            cvc.disableDefaultConstraintViolation();
            switch (size) {
                case 1 -> setMessage(cvc, STR_SIZE_ONE);
                case 2, 3, 4 -> setMessage(cvc, STR_SIZE_BETWEEN_TWO_AND_FOUR);
                default -> setMessage(cvc, STR_SIZE_MORE_THEN_FOUR);
            }
            return false;
        }
    }

    private void setMessage(ConstraintValidatorContext cvc, String str) {
        customMessageForValidation(cvc, str);
    }

    private void customMessageForValidation(ConstraintValidatorContext cvc, String message) {
        cvc.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
