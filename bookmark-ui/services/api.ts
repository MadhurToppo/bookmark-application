import axios from "axios";
import {BookmarksResponse} from "@/services/models";

const API_BASE_URL = "http://localhost:8080"
export const fetchBookmarks = async (): Promise<BookmarksResponse> => {
  const axiosResponse = await axios.get<BookmarksResponse>(`${API_BASE_URL}/api/bookmarks`)
  return axiosResponse.data
}