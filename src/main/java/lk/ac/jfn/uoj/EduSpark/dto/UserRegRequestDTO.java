package lk.ac.jfn.uoj.EduSpark.dto;

import lombok.Data;

@Data
public class UserRegRequestDTO {
    int id;
    String userName;
    String email;
    String password;
}
