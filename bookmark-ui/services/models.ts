export interface BookmarksResponse {
  bookmarks: Bookmark[],
  totalElements: number,
  currentPage: number,
  totalPages: number,
  isFirst: boolean,
  isLast: boolean,
  hasNext: boolean,
  hasPrevious: boolean
}

export interface Bookmark {
  id: number,
  name: string,
  url: string,
  creationTime: Date
}