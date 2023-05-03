import React from "react";
import {BookmarksResponse} from "@/services/models";
import Bookmark from "@/components/Bookmark";
import Pagination from "@/components/Pagination";

interface BookmarksProps {
  bookmarksResponse: BookmarksResponse,
  query?: string
}

const Bookmarks: React.FC<BookmarksProps> = ({bookmarksResponse, query}) => (
  <div>
    <Pagination bookmarks={bookmarksResponse} query={query}/>
    {bookmarksResponse.bookmarks.map(b => <Bookmark key={b.id} bookmark={b}/>)}
  </div>
)

export default Bookmarks