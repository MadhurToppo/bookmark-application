package com.madhurtoppo.bookmarkservice.entities;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDTO(Bookmark bookmark) {
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        bookmarkDTO.setId(bookmark.getId());
        bookmarkDTO.setName(bookmark.getName());
        bookmarkDTO.setCreationTime(bookmark.getCreationTime());
        return bookmarkDTO;
    }
}
