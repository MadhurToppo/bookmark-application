package com.madhurtoppo.bookmarkservice.entities;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarksDTO {
  private List<BookmarkDTO> bookmarks;
  private long totalElements;
  private int currentPage;
  private int totalPages;

  @JsonProperty("isFirst")
  private boolean isFirst;

  @JsonProperty("isLast")
  private boolean isLast;

  private boolean hasNext;
  private boolean hasPrevious;

  public BookmarksDTO(final Page<BookmarkDTO> bookmarkPage) {
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
