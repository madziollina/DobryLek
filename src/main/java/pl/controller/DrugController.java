package pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.entity.Drug;
import pl.entity.DrugsUsers;
import pl.entity.User;
import pl.repository.DrugRepository;
import pl.repository.DrugsUsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    DrugsUsersRepository drugsUsersRepository;


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("drug", new Drug());
        return "drug/form";
    }

    @GetMapping("/form/{id}")
    public String form(Model model, @PathVariable Long id) {
        model.addAttribute("drug", drugRepository.findOne(id));
        return "drug/form";
    }

    @PostMapping("/form")
    public String form(@Valid Drug drug, BindingResult err,
                       HttpServletRequest request, Model model, HttpSession session) {

        if (drug.getId() != null && err.hasErrors()) {
            return "drug/form";
        }

        List<User> users= drug.getUsers();
        users.add((User) session.getAttribute("user"));
        drug.setUsers(users);
        drugRepository.save(drug);

        if(drug.isMyDrug()) {
            session.setAttribute("drug", drug);

            return "redirect:" + request.getContextPath() + "/drug/myDrug/"+drug.getId();
        }

        return "redirect:"+request.getContextPath()+"/drug/list";

    }

    @GetMapping("/myDrug/{id}")
    public String myDrug(Model model,@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        DrugsUsers drugsUsers = drugsUsersRepository.findOneByDrugIdAndUsersId(id, user.getId());
        model.addAttribute("drugUser", drugsUsersRepository.findOneByDrugIdAndUsersId(id, user.getId()));
        return "drug/myDrug";
    }

    @PostMapping("/myDrug")
    public String myDrug(DrugsUsers drugUser,
                         HttpServletRequest request, Model model, HttpSession session){

      //  drugsUsersRepository.save(drugUser);

        User user = (User) session.getAttribute("user");
        Drug drug = (Drug) session.getAttribute("drug");
        DrugsUsers drugsUser = drugsUsersRepository.findOneByDrugIdAndUsersId(drug.getId(), user.getId());
        drugsUser.setMyDoze(drugUser.getMyDoze());
        drugsUser.setTime(drugUser.getTime());

        drugsUsersRepository.save(drugsUser);
        return "redirect:"+request.getContextPath()+"/drug/list";
    }

    @GetMapping("/list")
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("drugs", drugRepository.findAllByUsersId(user.getId()));
        return "drug/list";
    }

    @GetMapping("/confirm/{id}")
    public String cofirm(Model model, @PathVariable Long id){
        model.addAttribute("drug", drugRepository.findOne(id));
        return "drug/confirm";
    }

    @GetMapping("/delete/{id}")
    public String confirm(@PathVariable Long id){
        drugRepository.delete(drugRepository.findOne(id));
        return "drug/list";
    }
}
