package pl.javastart.validationtask;

import org.springframework.stereotype.Component;

@Component
public class RegisterFormMapper {
    public RegisterForm mapDtoToRegisterForm(RegisterFormDto registerFormDto) {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setFirstName(registerFormDto.getFirstName());
        registerForm.setSurname(registerFormDto.getSurname());
        registerForm.setAddress(registerFormDto.getAddress());
        registerForm.setCity(registerFormDto.getCity());
        registerForm.setPostalCode(registerFormDto.getPostalCode());
        registerForm.setEmail(registerFormDto.getEmail());
        registerForm.setPassword(registerFormDto.getPassword());
        registerForm.setTermsAgreement(registerFormDto.isTermsAgreement());
        return registerForm;
    }
}
