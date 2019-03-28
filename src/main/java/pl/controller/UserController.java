package pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.entity.User;
import pl.repository.UserRepository;
import pl.service.UserService;
import pl.validationGroup.FullValidation;
import pl.validationGroup.PartValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Validated({PartValidation.class}) User user, BindingResult err, Model model, HttpSession session, HttpServletRequest request) {
        if(err.hasErrors()){
            return "user/login";
        }
        try {

            User loggedInUser = userService.checkLogin(user.getEmail(), user.getPassword());
            session.setAttribute("user", loggedInUser);

            return "redirect:"+request.getContextPath()+"/logged/"+loggedInUser.getLogin();

        } catch (Exception e) {

            session.removeAttribute("user");
            model.addAttribute("errorMsg", e.getMessage());
            return "user/login";
        }
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/form")
    public String form(@Valid User user, BindingResult err,
                       @Validated({FullValidation.class}) User userFull, BindingResult errFull,
                       HttpServletRequest request, Model model, HttpSession session) {

        if (user.getId() != null && err.hasErrors()) {
            return "user/form";
        }
        if (user.getId() == null && errFull.hasErrors()) {
            model.addAttribute("user", userFull);
            return "user/form";
        }

        userService.save(user);

        session.setAttribute("user", user);

        return "redirect:"+request.getContextPath()+"/logged/"+user.getLogin();
        /*try {

            User loggedInUser = userService.checkLogin(userFull.getEmail(), userFull.getPassword());
            session.setAttribute("user", loggedInUser);
            return "redirect:"+request.getContextPath()+"/logged";

        } catch (Exception e) {

            session.removeAttribute("user");
            model.addAttribute("errorMsg", e.getMessage());
            return "user/login";
        }
        */


    }

    @GetMapping("/myData/{id}")
    public String myData(Model model, @PathVariable Long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user/myData";
    }

    @PostMapping("/myData")
    public String myData(@Valid User user, BindingResult err,
                       @Validated({FullValidation.class}) User userFull, BindingResult errFull,
                       HttpServletRequest request, Model model, HttpSession session) {

        if (user.getId() != null && err.hasErrors()) {
            return "user/myData";
        }
        if (user.getId() == null && errFull.hasErrors()) {
            model.addAttribute("user", userFull);
            return "user/myData";
        }

        userService.save(user);

        session.setAttribute("user", user);

        return "redirect:"+request.getContextPath()+"/logged/"+user.getLogin();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "/home/home";
    }
}
