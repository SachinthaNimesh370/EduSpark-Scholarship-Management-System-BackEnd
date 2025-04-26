package lk.ac.jfn.uoj.EduSpark.service;



import java.util.Map;

public interface JWTService {

    public String jwtToken(String subject, Map<String,String> clams);
    public String getUserName(String token);


}
