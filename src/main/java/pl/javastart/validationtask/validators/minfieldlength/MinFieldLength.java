package pl.javastart.validationtask.validators.minfieldlength;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = MinFieldLengthValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface MinFieldLength {
    String message() default "pole musi mieć conajmniej {size} znaków";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int size() default 1;
}
