package com.madhurtoppo.bookmarkservice.repositories;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
