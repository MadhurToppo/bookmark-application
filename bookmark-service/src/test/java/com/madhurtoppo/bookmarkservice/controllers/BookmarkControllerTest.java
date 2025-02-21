package com.madhurtoppo.bookmarkservice.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import com.madhurtoppo.bookmarkservice.repositories.BookmarkRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = { "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo" })
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

  @ParameterizedTest
  @CsvSource({ "1, 16, 2, 1, true, false, true, false", "2, 16, 2, 2, false, true, false, true" })
  void shouldGetBookmarks(final int pageNo, final int totalElements, final int totalPages, final int currentPage,
      final boolean isFirst,
      final boolean isLast, final boolean hasNext, final boolean hasPrevious) throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page=" + pageNo))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
        .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
        .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
        .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
        .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
        .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
        .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
  }

  @Test
  void shouldCreateBookmarkSuccessfully() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/bookmarks")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "name": "Madhur Facebook",
              "url": "www.facebook.com/madhurtoppo"
            }
              """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", notNullValue()))
        .andExpect(jsonPath("$.name", is("Madhur Facebook")))
        .andExpect(jsonPath("$.url", is("www.facebook.com/madhurtoppo")));
  }

  @Test
  void shouldFailToCreateBookmarkWhenUrlNotPresent() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/bookmarks")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "name": "Madhur Facebook"
            }
            """))
        .andExpect(status().isBadRequest())
        .andExpect(header().string("Content-Type", is("application/problem+json")))
        .andExpect(jsonPath("$.type", is("https://zalando.github.io/problem/constraint-violation")))
        .andExpect(jsonPath("$.title", is("Constraint Violation")))
        .andExpect(jsonPath("$.status", is(400)))
        .andExpect(jsonPath("$.violations", hasSize(1)))
        .andExpect(jsonPath("$.violations[0].field", is("url")))
        .andExpect(jsonPath("$.violations[0].message", is("Url should not be empty")))
        .andReturn();
  }
}
