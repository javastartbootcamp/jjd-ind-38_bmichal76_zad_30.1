package pl.javastart.validationtask.validators.postcodepl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PostCodePlValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface PostCodePl {
    String message() default "Błędny format kodu pocztowego";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String pattern() default "XX-XXX";
}
