package durgeshkafka.controller;

import durgeshkafka.common.Constant;
import durgeshkafka.configuration.ResponseDTO;
import durgeshkafka.configuration.JwtUtil;
import durgeshkafka.configuration.MyUserDetails;
import durgeshkafka.credentialpayloads.AuthRequest;
import durgeshkafka.entity.User;
import durgeshkafka.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetails myUserDetailsService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, MyUserDetails myUserDetailsService, UserRepository userRepository, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody @Valid AuthRequest authRequest) {
        Authentication authenticate;
        User user = userRepository.findByEmail(authRequest.getEmail());

        if (user == null) {
            return new ResponseDTO( HttpStatus.NOT_FOUND,Constant.User.USER_NOT_FOUND, authRequest.getEmail());
        }

        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        } catch (Exception e) {
            return new ResponseDTO( HttpStatus.BAD_REQUEST,Constant.AUTH.PASSWORD_INCORRECT, authRequest.getPassword());
        }

        if (authenticate.isAuthenticated()) {
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authRequest.getEmail());
            String token = jwtUtil.generateToken(userDetails);
            return new ResponseDTO( HttpStatus.ACCEPTED, Constant.User.USER_LOGIN, token);
        } else {
            return new ResponseDTO( HttpStatus.UNAUTHORIZED,Constant.User.USER_LOGIN_FAILED, null);
        }
    }
}
