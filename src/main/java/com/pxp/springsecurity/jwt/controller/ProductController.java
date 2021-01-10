package com.pxp.springsecurity.jwt.controller;

import com.pxp.springsecurity.jwt.model.AuthenticationRequest;
import com.pxp.springsecurity.jwt.service.JwtService;
import com.pxp.springsecurity.jwt.service.PXPUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PXPUserDetailsService userDetailsService;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello PXP!";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String getJWTAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect User Name or Password", e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtService.getJWT(userDetails);
        System.out.println("jwt: " + jwt);
        return jwt;
    }
}
