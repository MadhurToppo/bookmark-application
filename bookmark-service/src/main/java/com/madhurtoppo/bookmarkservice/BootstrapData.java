package com.madhurtoppo.bookmarkservice;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import com.madhurtoppo.bookmarkservice.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;
    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "GithubMadhur", "https://github.com/MadhurToppo", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "LinkedInMadhur", "https://www.linkedin.com/in/madhurtoppo/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Spring", "https://start.spring.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Micronaut", "https://micronaut.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Quarkus", "https://quarkus.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Java", "https://www.java.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Microservices", "https://microservices.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Refactoring", "https://www.refactoring.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Apache Kafka", "https://kafka.apache.org", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Docker", "https://www.docker.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kubernetes", "https://kubernetes.io", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Martin Fowler", "https://martinfowler.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Javascript", "https://www.javascript.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "React", "https://react.dev", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Next JS", "https://nextjs.org", Instant.now()));
    }
}
