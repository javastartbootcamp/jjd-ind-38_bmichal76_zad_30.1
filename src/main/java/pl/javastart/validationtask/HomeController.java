package pl.javastart.validationtask;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    private final RegisterFormService registerFormService;

    public HomeController(RegisterFormService registerFormService) {
        this.registerFormService = registerFormService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", new RegisterFormDto());
        return "home";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("data") RegisterFormDto registerFormDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "home";
        } else {
            model.addAttribute("formData", registerFormDto);
            registerFormService.save(registerFormDto);
            return "success";
        }
    }
}
