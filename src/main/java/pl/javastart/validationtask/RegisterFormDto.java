package pl.javastart.validationtask;

import org.springframework.validation.annotation.Validated;
import pl.javastart.validationtask.validators.minfieldlength.MinFieldLength;
import pl.javastart.validationtask.validators.password.Password;
import pl.javastart.validationtask.validators.postcodepl.PostCodePl;

import javax.validation.constraints.*;

@Validated
public class RegisterFormDto {

    private static final String EMPTY_MSG = "Pole nie może być puste";
    @NotEmpty(message = EMPTY_MSG)
    @MinFieldLength(size = 3)
    private String firstName;
    @NotEmpty(message = EMPTY_MSG)
    @MinFieldLength(size = 3)
    private String surname;
    @NotEmpty(message = EMPTY_MSG)
    private String address;
    @NotEmpty(message = EMPTY_MSG)
    @PostCodePl
    private String postalCode;
    @NotEmpty(message = EMPTY_MSG)
    private String city;
    @NotEmpty(message = EMPTY_MSG)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$",
            message = "musi być poprawnie sformatowanym adresem e-mail")
    private String email;
    @NotEmpty(message = EMPTY_MSG)
    @MinFieldLength(size = 8)
    @Password
    private String password;
    @AssertTrue(message = "Akceptacja regulaminu jest wymagana")
    private boolean termsAgreement;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTermsAgreement() {
        return termsAgreement;
    }

    public void setTermsAgreement(boolean termsAgreement) {
        this.termsAgreement = termsAgreement;
    }
}
