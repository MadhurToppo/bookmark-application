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
    }
}
