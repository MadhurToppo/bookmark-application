package com.madhurtoppo.bookmarkservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    @Id
    @SequenceGenerator(name = "bookmark_id_sequence_generator", sequenceName = "bookmark_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String url;
    private Instant creationTime;
}
