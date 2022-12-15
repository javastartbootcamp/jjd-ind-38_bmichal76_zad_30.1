package pl.javastart.validationtask.validators.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface Password {
    String message() default "hasło musi zawierać 1 znak mały, duży i specjalny";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
