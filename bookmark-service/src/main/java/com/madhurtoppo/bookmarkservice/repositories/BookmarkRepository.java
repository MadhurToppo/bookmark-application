package com.madhurtoppo.bookmarkservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import com.madhurtoppo.bookmarkservice.entities.BookmarkDTO;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
  @Query("select new com.madhurtoppo.bookmarkservice.entities.BookmarkDTO(b.id, b.name, b.url,"
      + " b.creationTime) from Bookmark b")
  Page<BookmarkDTO> findBookmarks(Pageable pageable);

  Page<BookmarkDTO> findByNameContainingIgnoreCase(String query, Pageable pageable);
}
