package com.example.gameplatform.GamePlatform.Service;

import com.example.gameplatform.GamePlatform.DTOs.RegisterDTO;
import com.example.gameplatform.GamePlatform.DTOs.UserDTO;
import com.example.gameplatform.GamePlatform.Entities.User;
import com.example.gameplatform.GamePlatform.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
@Transactional
public class UserService {

        @Autowired
        UserRepository userRepository;
    ModelMapper mapper=new ModelMapper();
    public List<UserDTO>getAllUsers()
    {
      return userRepository.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }
    public boolean createNewUser(RegisterDTO newUser)
    {User user=mapper.map(newUser,User.class);
        log.info("Service called createNewUser");

        String id= UUID.randomUUID().toString();
        user.setUserID(id);
        user.setUserName(newUser.getName());
        if(newUser.getEmail().equals(""))
        {
            return false;
        }
        user.setUserEmail(newUser.getEmail());

        if(newUser.getPassword().equals(""))
        {
            return false;
        }
        user.setUserPassword(newUser.getPassword());
        User fromDb=userRepository.save(user);
        return ObjectUtils.isNotEmpty(fromDb);
    }
    public boolean loginUser(String email,String password)
    {
     User user= userRepository.loginUser(email, password);
     log.info("user is",user.getUserEmail());
     return ObjectUtils.isNotEmpty(user);
    }
}
