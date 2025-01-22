package com.gestion.stock.gestion_stock.service;


import com.gestion.stock.gestion_stock.Repository.UserRepositroy;
import com.gestion.stock.gestion_stock.entities.User;
import com.gestion.stock.gestion_stock.request.LoginUserDto;
import com.gestion.stock.gestion_stock.request.RegisterUserDto;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthenticationService {
    private final UserRepositroy userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepositroy userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        var user = new User();
        user.setNom(input.getNom());
        user.setEmail(input.getEmail());
        user.setMotDePasse(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());

        return userRepository.save(user);
    }


    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    ;
}


