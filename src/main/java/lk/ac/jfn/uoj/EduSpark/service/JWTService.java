package lk.ac.jfn.uoj.EduSpark.service;

public interface JWTService {

    public String jwtToken();
    public String getUserName(String token);
}
