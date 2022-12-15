package pl.javastart.validationtask;

import org.springframework.stereotype.Service;

@Service
public class RegisterFormService {
    private final RegisterFormRepository registerFormRepository;
    private final RegisterFormMapper registerFormMapper;

    public RegisterFormService(RegisterFormRepository registerFormRepository, RegisterFormMapper registerFormMapper) {
        this.registerFormRepository = registerFormRepository;
        this.registerFormMapper = registerFormMapper;
    }

    public void save(RegisterFormDto registerFormDto) {
        RegisterForm registerForm = registerFormMapper.mapDtoToRegisterForm(registerFormDto);
        registerFormRepository.save(registerForm);
    }
}
