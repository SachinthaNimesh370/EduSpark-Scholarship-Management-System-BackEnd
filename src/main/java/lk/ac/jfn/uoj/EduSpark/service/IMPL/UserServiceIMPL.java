package lk.ac.jfn.uoj.EduSpark.service.IMPL;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;
import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import lk.ac.jfn.uoj.EduSpark.repo.UserRepository;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import lk.ac.jfn.uoj.EduSpark.utill.ServiceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceIMPL jwtService;

    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTServiceIMPL jwtService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public String signUp(UserRegRequestDTO userRegRequestDTO) {
        try {
            UserEntity userEntity=modelMapper.map(userRegRequestDTO,UserEntity.class);
            userEntity.setPassword(passwordEncoder.encode(userRegRequestDTO.getPassword()));
            System.out.println(userEntity.getPassword());
            userRepository.save(userEntity);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    public ServiceResponse signIn(UserLoginRequestDTO userLoginRequestDTO) {
        if(isEnablePerson(userLoginRequestDTO.getUserName())){
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userLoginRequestDTO.getUserName(),userLoginRequestDTO.getPassword()));
                return new ServiceResponse(true,jwtService.jwtToken(userLoginRequestDTO.getUserName()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ServiceResponse(false,"Login failed. Please check your password.");
            }
        }
        else{
            return new ServiceResponse(false,"Login failed. No registered user found with the provided information.");
        }
    }

    @Override
    public boolean isEnablePerson(String userName) {
        return userRepository.existsByName(userName);
    }
}
