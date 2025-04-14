package lk.ac.jfn.uoj.EduSpark.controller;

import lk.ac.jfn.uoj.EduSpark.dto.UserDTO;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUp(@RequestBody UserDTO userDTO){
        userService.signUp(userDTO);
        return "";
    }
}
