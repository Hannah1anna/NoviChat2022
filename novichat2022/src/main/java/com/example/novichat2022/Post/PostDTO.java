package com.example.novichat2022.Post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private String text;
    private String username;
}
