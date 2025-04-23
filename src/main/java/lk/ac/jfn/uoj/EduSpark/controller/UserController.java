package lk.ac.jfn.uoj.EduSpark.controller;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserLoginResponceDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;
import lk.ac.jfn.uoj.EduSpark.service.JWTService;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/signup")
    public String signUp(@RequestBody UserRegRequestDTO userRegRequestDTO){
        userService.signUp(userRegRequestDTO);
        return "";
    }
    @GetMapping("/signin")
    public UserLoginResponceDTO signIn(@RequestBody UserLoginRequestDTO userLoginRequestDTO){

        String token = userService.signIn(userLoginRequestDTO);
        return  new UserLoginResponceDTO(token,LocalDateTime.now());
    }

}
