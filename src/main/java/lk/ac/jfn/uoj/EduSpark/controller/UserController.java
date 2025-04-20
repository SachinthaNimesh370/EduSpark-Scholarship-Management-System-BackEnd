package lk.ac.jfn.uoj.EduSpark.controller;

import lk.ac.jfn.uoj.EduSpark.dto.UserDTO;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // 👈 Add this
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
