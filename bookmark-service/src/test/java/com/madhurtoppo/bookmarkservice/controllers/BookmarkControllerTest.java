package com.madhurtoppo.bookmarkservice.controllers;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import com.madhurtoppo.bookmarkservice.repositories.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
class BookmarkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAll();
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "GithubMadhur", "https://github.com/MadhurToppo", Instant.now()));
        bookmarks.add(new Bookmark(null, "LinkedInMadhur", "https://www.linkedin.com/in/madhurtoppo/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Spring", "https://start.spring.io", Instant.now()));
        bookmarks.add(new Bookmark(null, "Micronaut", "https://micronaut.io", Instant.now()));
        bookmarks.add(new Bookmark(null, "Quarkus", "https://quarkus.io", Instant.now()));
        bookmarks.add(new Bookmark(null, "Java", "https://www.java.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Microservices", "https://microservices.io", Instant.now()));
        bookmarks.add(new Bookmark(null, "Refactoring", "https://www.refactoring.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Apache Kafka", "https://kafka.apache.org", Instant.now()));
        bookmarks.add(new Bookmark(null, "Docker", "https://www.docker.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes", "https://kubernetes.io", Instant.now()));
        bookmarks.add(new Bookmark(null, "Martin Fowler", "https://martinfowler.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Javascript", "https://www.javascript.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "React", "https://react.dev", Instant.now()));
        bookmarks.add(new Bookmark(null, "Next JS", "https://nextjs.org", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @Test
    void shouldGetBookmarks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(16)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(2)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)))
                .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(false)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(true)))
                .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(false)));
    }
}