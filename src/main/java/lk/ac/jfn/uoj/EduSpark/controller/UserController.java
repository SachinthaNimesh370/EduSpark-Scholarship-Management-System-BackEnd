package lk.ac.jfn.uoj.EduSpark.controller;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserLoginResponceDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;
import lk.ac.jfn.uoj.EduSpark.service.JWTService;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import lk.ac.jfn.uoj.EduSpark.utill.ServiceResponse;
import lk.ac.jfn.uoj.EduSpark.utill.StandardResponce;
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
    public ResponseEntity<StandardResponce> signUp(@RequestBody UserRegRequestDTO userRegRequestDTO){
        ServiceResponse massage = userService.signUp(userRegRequestDTO);
        if(massage.isSuccess()){
            return new ResponseEntity<StandardResponce>(
                    new StandardResponce(
                            200, "Ok", massage.getObject()),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<StandardResponce>(
                    new StandardResponce(
                            400, "Bad", massage.getObject()),
                    HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/signin")
    public ResponseEntity<StandardResponce> signIn(@RequestBody UserLoginRequestDTO userLoginRequestDTO){

        ServiceResponse massage = userService.signIn(userLoginRequestDTO);
        if(massage.isSuccess()){
            return  new ResponseEntity<StandardResponce>(
                    new StandardResponce(
                            200,"Ok",new UserLoginResponceDTO(
                                    massage.getObject(), LocalDateTime.now())),
                    HttpStatus.OK);
        }else {
            return  new ResponseEntity<StandardResponce>(
                    new StandardResponce(
                            400,"Bad", new UserLoginResponceDTO(
                                    massage.getObject(),null)),
                    HttpStatus.BAD_REQUEST);
        }

    }

}
