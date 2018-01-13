package com.medo.shopsv1.controllers;


import com.medo.shopsv1.models.LoginForm;
import com.medo.shopsv1.models.RegisterForm;
import com.medo.shopsv1.models.User;
import com.medo.shopsv1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private UserRepository uRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository uRepo, PasswordEncoder passwordEncoder) {
        this.uRepo = uRepo;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginForm loginForm){
        Optional<User> userOptional =   uRepo.findByEmail(loginForm.getEmail());
        if(userOptional.isPresent()){
                User user  = userOptional.get();
                if(passwordEncoder.matches(loginForm.getPassword(),user.getPassword())){
                    return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
                }else{
                    return new ResponseEntity<>("The password did not match",HttpStatus.NOT_FOUND);
                }
        }
        return new ResponseEntity<>("No user with email " + loginForm.getEmail() + " was found",HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param registerForm
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterForm registerForm){
        Optional<User> userOptional = uRepo.findByEmail(registerForm.getEmail());
        if(userOptional.isPresent()){
            return new ResponseEntity<>("Email already exist please choose another email",HttpStatus.NOT_FOUND);
        }
        User newUser = new User();
        newUser.setFirst_name(registerForm.getFirst_name());
        newUser.setLast_name(registerForm.getLast_name());
        newUser.setEmail(registerForm.getEmail());
        String encodedPassword = passwordEncoder.encode(registerForm.getPassword());
        newUser.setPassword(encodedPassword);
        uRepo.save(newUser);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

}
