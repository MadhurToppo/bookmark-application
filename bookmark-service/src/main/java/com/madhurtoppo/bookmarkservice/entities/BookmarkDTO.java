package com.madhurtoppo.bookmarkservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkDTO {
    private Long id;
    private String name;
    private String url;
    private Instant creationTime;
}
