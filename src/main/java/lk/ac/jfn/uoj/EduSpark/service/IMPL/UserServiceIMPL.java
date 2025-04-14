package lk.ac.jfn.uoj.EduSpark.service.IMPL;

import lk.ac.jfn.uoj.EduSpark.DTO.UserDTO;
import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import lk.ac.jfn.uoj.EduSpark.repo.UserRepository;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String signUp(UserDTO userDTO) {
        try {
            UserEntity userEntity=modelMapper.map(userDTO,UserEntity.class);
            userRepository.save(userEntity);
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
