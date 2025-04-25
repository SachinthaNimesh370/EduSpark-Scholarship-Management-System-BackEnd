package lk.ac.jfn.uoj.EduSpark.service;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;

public interface UserService {
    String signUp(UserRegRequestDTO userRegRequestDTO);
    String signIn(UserLoginRequestDTO userLoginRequestDTO);

    boolean isEnablePerson(String userName);


}
