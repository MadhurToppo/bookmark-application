package com.madhurtoppo.bookmarkservice.entities;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkDTO {
    private Long id;
    private String name;
    private String url;
    private Instant creationTime;
}
