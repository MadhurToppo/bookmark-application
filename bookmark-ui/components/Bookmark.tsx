import React from "react";
import {Bookmark} from "@/services/models";

interface BookmarkProps {
  bookmark: Bookmark
}

const Bookmark: React.FC<BookmarkProps> = ({bookmark}) => (
  <div>
    <h2>{bookmark.name}</h2>
    <h2>{bookmark.url}</h2>
  </div>
)

export default Bookmark;