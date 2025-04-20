package lk.ac.jfn.uoj.EduSpark.controller;

import lk.ac.jfn.uoj.EduSpark.service.JWTService;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173") // 👈 Add this
@RestController
@RequestMapping("/home")
public class HomeController {
    private final JWTService jwtService;

    public HomeController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/login")
    public String login(){
        return jwtService.jwtToken();
    }
    @GetMapping("/username")
    public String getUserName(@RequestParam  String token){
        return jwtService.getUserName(token);
    }
}
