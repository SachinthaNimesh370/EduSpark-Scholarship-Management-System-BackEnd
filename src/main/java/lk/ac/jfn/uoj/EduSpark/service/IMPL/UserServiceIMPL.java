package lk.ac.jfn.uoj.EduSpark.service.IMPL;

import lk.ac.jfn.uoj.EduSpark.dto.UserDTO;
import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import lk.ac.jfn.uoj.EduSpark.repo.UserRepository;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String signUp(UserDTO userDTO) {
        try {
            UserEntity userEntity=modelMapper.map(userDTO,UserEntity.class);
            userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            System.out.println(userEntity.getPassword());
            userRepository.save(userEntity);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
