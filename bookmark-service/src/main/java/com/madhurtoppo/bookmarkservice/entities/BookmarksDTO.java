package com.madhurtoppo.bookmarkservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookmarksDTO {
    private List<Bookmark> bookmarks;
    private long totalElements;
    private int currentPage;
    private int totalPages;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("hasLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<Bookmark> bookmarkPage) {
        this.setBookmarks(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setCurrentPage(bookmarkPage.getNumber() + 1);
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setFirst(bookmarkPage.isFirst());
        this.setLast(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }
}
