import React from "react";
import {BookmarksResponse} from "@/services/models";

interface BookmarksProps {
  bookmarksResponse: BookmarksResponse
}

const Bookmarks: React.FC<BookmarksProps> = ({bookmarksResponse}) => (
  <div>
    {bookmarksResponse.bookmarks.map(bookmark => <h2 key={bookmark.name}>{bookmark.name}</h2>)}
  </div>
)

export default Bookmarks