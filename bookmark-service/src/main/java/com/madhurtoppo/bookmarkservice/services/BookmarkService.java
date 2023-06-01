package com.madhurtoppo.bookmarkservice.services;

import com.madhurtoppo.bookmarkservice.entities.*;
import com.madhurtoppo.bookmarkservice.repositories.BookmarkRepository;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper mapper;

    @Transactional(readOnly = true)
    public BookmarksDTO getAllBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "creationTime");
        Page<BookmarkDTO> bookmarks = bookmarkRepository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarks);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "creationTime");
        Page<BookmarkDTO> bookmarks = bookmarkRepository.findByNameContainingIgnoreCase(query, pageable);
        return new BookmarksDTO(bookmarks);
    }

    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        Bookmark bookmark = new Bookmark(null, request.getName(), request.getUrl(), Instant.now());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return mapper.toDTO(savedBookmark);
    }
}
