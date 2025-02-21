package com.madhurtoppo.bookmarkservice.entities;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

  public BookmarkDTO toDTO(final Bookmark bookmark) {
    return new BookmarkDTO(
        bookmark.getId(),
        bookmark.getName(),
        bookmark.getUrl(),
        bookmark.getCreationTime());
  }
}
