package com.example.gameplatform.GamePlatform.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Users")
public class User {
    @Id
    @NotNull
    @Column(name="ID")
    private String userID;

    @NotNull
    @Column(name="Name")
    private String userName;

    @NotNull
    @Column(name="Username")
    private String userUsername;

    @NotNull
    @Column(name="Password")
    private String userPassword;

    @NotNull
    @Column(name="Email")
    private String userEmail;
}
