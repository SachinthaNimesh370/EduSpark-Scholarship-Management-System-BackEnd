package lk.ac.jfn.uoj.EduSpark.config;


import lk.ac.jfn.uoj.EduSpark.service.IMPL.MyUserDetailServiceIMPL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final MyUserDetailServiceIMPL myUserDetailServiceIMPL;

    public SecurityConfig(MyUserDetailServiceIMPL myUserDetailServiceIMPL) {
        this.myUserDetailServiceIMPL = myUserDetailServiceIMPL;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(c->c.disable())
                .sessionManagement(s->s
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(r->r
                        .requestMatchers("api/v1/home/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .authenticationProvider(daoAuthenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailServiceIMPL);
        provider.setPasswordEncoder(passwordEncoder());
        return  provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
