package lk.ac.jfn.uoj.EduSpark.service;

public interface JWTService {

    public String jwtToken(String subject);
    public String getUserName(String token);
}
