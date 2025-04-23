package lk.ac.jfn.uoj.EduSpark.service.IMPL;

import lk.ac.jfn.uoj.EduSpark.dto.UserLoginRequestDTO;
import lk.ac.jfn.uoj.EduSpark.dto.UserRegRequestDTO;
import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import lk.ac.jfn.uoj.EduSpark.repo.UserRepository;
import lk.ac.jfn.uoj.EduSpark.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceIMPL implements UserDetailsService {
    private final UserRepository userRepository;



    public MyUserDetailServiceIMPL(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =userRepository.findByName(username).orElse(null);
        if(userEntity != null){
            UserDetails user = User.builder()
                    .username(userEntity.getName())
                    .password(userEntity.getPassword())
                    .build();
            return user;
        }else {
            return null;
        }

    }




}
