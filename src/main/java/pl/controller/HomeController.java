package pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.entity.Connect;
import pl.repository.ConnectRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ConnectRepository connectRepository;

    @GetMapping("/home")
    public String home() {
        return "home/home";
    }

    @GetMapping("/check")
    public String checkMed(Model model){
        model.addAttribute("connect", new Connect());
        return "home/check";
    }
    @PostMapping("/check")
    public String checkMed(Connect connect, HttpServletRequest request){
        Connect connect1 = new Connect();

        connect1 = connectRepository.findOneByDrug1AndDrug2(connect.getDrug1(), connect.getDrug2());
        if (connect1==null){
            connect1.setId((long) 0);
        }
        return "redirect:"+request.getContextPath()+"result/"+connect1.getId();
    }

    @GetMapping("/result/{id}")
    public String result(@PathVariable Long id, Model model){
        if (id==0){
            Connect connect1 = new Connect();
            connect1.setResult("brak danych");
            model.addAttribute("connect", connect1);
        }
        model.addAttribute("connect", connectRepository.findOne(id));
        return "home/result";
    }

}
