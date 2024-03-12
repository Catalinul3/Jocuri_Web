package com.example.gameplatform.GamePlatform.Repository;

import com.example.gameplatform.GamePlatform.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.userPassword = :password")
    public User loginUser(@Param("email") String email, @Param("password") String password);}

