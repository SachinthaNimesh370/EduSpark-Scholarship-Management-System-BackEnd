package lk.ac.jfn.uoj.EduSpark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {
    @GetMapping("/login")
    public String login(){
        return "ok";
    }
}
