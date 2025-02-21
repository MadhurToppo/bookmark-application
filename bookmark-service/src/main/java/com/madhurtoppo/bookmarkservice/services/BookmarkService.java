package com.madhurtoppo.bookmarkservice.services;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madhurtoppo.bookmarkservice.entities.Bookmark;
import com.madhurtoppo.bookmarkservice.entities.BookmarkDTO;
import com.madhurtoppo.bookmarkservice.entities.BookmarkMapper;
import com.madhurtoppo.bookmarkservice.entities.BookmarksDTO;
import com.madhurtoppo.bookmarkservice.entities.CreateBookmarkRequest;
import com.madhurtoppo.bookmarkservice.repositories.BookmarkRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

  private final BookmarkRepository bookmarkRepository;
  private final BookmarkMapper mapper;

  @Transactional(readOnly = true)
  public BookmarksDTO getAllBookmarks(final Integer page) {
    final int pageNo = page < 1 ? 0 : page - 1;
    final Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "creationTime");
    final Page<BookmarkDTO> bookmarks = bookmarkRepository.findBookmarks(pageable);
    return new BookmarksDTO(bookmarks);
  }

  @Transactional(readOnly = true)
  public BookmarksDTO searchAllBookmarks(final String query, final Integer page) {
    final int pageNo = page < 1 ? 0 : page - 1;
    final Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "creationTime");
    final Page<BookmarkDTO> bookmarks = bookmarkRepository.findByNameContainingIgnoreCase(query, pageable);
    return new BookmarksDTO(bookmarks);
  }

  public BookmarkDTO createBookmark(final CreateBookmarkRequest request) {
    final Bookmark bookmark = new Bookmark(null, request.getName(), request.getUrl(), Instant.now());
    final Bookmark savedBookmark = bookmarkRepository.save(bookmark);
    return mapper.toDTO(savedBookmark);
  }
}
