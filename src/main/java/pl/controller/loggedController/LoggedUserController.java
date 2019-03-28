package pl.controller.loggedController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.repository.UserRepository;

@Controller
@RequestMapping("/logged")
public class LoggedUserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/{login}")
    public String homeUser(Model model, @PathVariable String login) {
        model.addAttribute("user", userRepository.findOneByLogin(login));
        return "logged/homeUser";
    }
}
