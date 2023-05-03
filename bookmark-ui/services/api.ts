import axios from "axios";
import {BookmarksResponse} from "@/services/models";

const API_BASE_URL = "http://localhost:8080";
export const fetchBookmarks = async (page: number, query: String): Promise<BookmarksResponse> => {
  let url = `${API_BASE_URL}/api/bookmarks?page=${page }`;
  if (query) {
    url += `&query=${query}`;
  }
  const axiosResponse = await axios.get<BookmarksResponse>(url);
  return axiosResponse.data;
};

export const saveBookmark = async (bookmark:{name: string, url: string}) => {
  const axiosResponse = await axios.post(`${API_BASE_URL}/api/bookmarks`, bookmark);
  return axiosResponse.data;
};