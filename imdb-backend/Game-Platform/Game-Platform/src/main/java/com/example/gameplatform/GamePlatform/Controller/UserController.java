package com.example.gameplatform.GamePlatform.Controller;

import com.example.gameplatform.GamePlatform.DTOs.RegisterDTO;
import com.example.gameplatform.GamePlatform.DTOs.UserDTO;
import com.example.gameplatform.GamePlatform.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
        log.info("getAllUsers has started ...");
        List<UserDTO>result=service.getAllUsers();
        return result;
    }
    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody RegisterDTO newUser)
    {
        log.info("register has started ...");
        return service.createNewUser(newUser)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();

    }
    @GetMapping("/loginUser")
    public ResponseEntity loginUser( String email, String password)
    {
        log.info("login has started");
   return service.loginUser(email, password)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
