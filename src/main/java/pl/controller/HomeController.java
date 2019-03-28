package pl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.entity.Connect;
import pl.repository.ConnectRepository;

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
/*
    @PostMapping("/check")
    public String checkMed(List<String> drugs){
        Connect connect = new Connect();
        connect.setResult("brak danych");

        connect = connectRepository.getByDrug1AndDrug2(drugs.get(1), drugs.get(2));

        return "home/result"+connect.getResult();
    }
    */
}
