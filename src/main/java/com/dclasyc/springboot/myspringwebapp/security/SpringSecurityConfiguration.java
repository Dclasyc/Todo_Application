package com.dclasyc.springboot.myspringwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userDetails1 = createNewUser("Dclasyc", "111111");
        UserDetails userDetails2 = createNewUser("Oladipo", "user12");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
               .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Protect All Urls
    //A login form is shown for unauthorized request
    //CSRF disable
    //disable Frame options

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //cos we overide the default secutity features with this method, we need to define them again
        //then we can continue wtih the customized security features we need
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf(csrf -> csrf.disable() );
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()) );
        
        return http.build();

    }

}
