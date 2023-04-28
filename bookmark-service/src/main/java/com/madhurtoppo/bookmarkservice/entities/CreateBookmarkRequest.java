package com.madhurtoppo.bookmarkservice.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookmarkRequest {
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Url should not be empty")
    private String url;
}
