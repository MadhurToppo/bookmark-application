import React from "react";
import {BookmarksResponse} from "@/services/models";
import Bookmark from "@/components/Bookmark";

interface BookmarksProps {
  bookmarksResponse: BookmarksResponse
}

const Bookmarks: React.FC<BookmarksProps> = ({bookmarksResponse}) => (
  <div>
    {bookmarksResponse.bookmarks.map(b => <Bookmark key={b.id} bookmark={b}/>)}
  </div>
)

export default Bookmarks