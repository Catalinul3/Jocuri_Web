package com.example.gameplatform.GamePlatform.DTOs;

import com.example.gameplatform.GamePlatform.Helpers.Genre;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
public class GameDTO {
    private String id;
    private String title;
    private String background;
    private String description;
    private int rating;
    private String poster;
    private Genre genre;
    private int pg;
    private int year;
    private String name;

}
