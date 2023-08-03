package com.dclasyc.springboot.myspringwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String userName, String password){

      boolean isValidUserName = userName.equalsIgnoreCase("Dclasyc");
      boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidUserName && isValidPassword;
    }
}
