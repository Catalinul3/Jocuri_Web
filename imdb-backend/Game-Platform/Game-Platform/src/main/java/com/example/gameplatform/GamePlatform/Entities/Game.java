package com.example.gameplatform.GamePlatform.Entities;

import com.example.gameplatform.GamePlatform.Helpers.Genre;
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
@Table(name="game")
public class Game {
    @Id
    @NotNull
    @Column(name="ID")
    private String id;
    @NotNull
    @Column(name="Title", length=1000)
    private String title;
    @NotNull
    @Column(name="Background", length=1000)
    private String background;
    @NotNull
    @Column(name="Description", length=1000)
    private String description;
    @NotNull
    @Column(name="Rating")
    private int rating;
    @NotNull
    @Column(name="Poster", length = 1000)
    private String poster;
    @NotNull
    @Column(name="Genre")
    private Genre genre;
    @NotNull
    @Column(name="Pg")
    private int pg;
    @NotNull
    @Column(name="Year")
    private int year;
    @NotNull
    @Column(name="Name")
    private String name;
}
