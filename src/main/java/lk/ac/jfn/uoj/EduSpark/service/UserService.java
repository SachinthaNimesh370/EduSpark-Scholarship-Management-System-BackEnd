package lk.ac.jfn.uoj.EduSpark.service;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;
import lk.ac.jfn.uoj.EduSpark.utill.ServiceResponse;

public interface UserService {
    ServiceResponse signUp(UserRegRequestDTO userRegRequestDTO);
    ServiceResponse signIn(UserLoginRequestDTO userLoginRequestDTO);

    boolean isEnablePerson(String userName);


}
