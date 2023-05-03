import axios from "axios";
import {BookmarksResponse} from "@/services/models";
import getConfig from 'next/config';

const {serverRuntimeConfig, publicRuntimeConfig} = getConfig();

const apiGetUrl = () => {
  return serverRuntimeConfig.API_BASE_URL || publicRuntimeConfig.API_BASE_URL
}

export const fetchBookmarks = async (page: number, query: String): Promise<BookmarksResponse> => {
  console.log("From Fetch bookmarks, serverRuntimeConfig:", serverRuntimeConfig);
  console.log("From Fetch bookmarks, publicRuntimeConfig", publicRuntimeConfig);

  let url = `${apiGetUrl()}/api/bookmarks?page=${page}`;
  if (query) {
    url += `&query=${query}`;
  }
  const axiosResponse = await axios.get<BookmarksResponse>(url);
  return axiosResponse.data;
};

export const saveBookmark = async (bookmark: { name: string, url: string }) => {
  console.log("From add bookmark, serverRuntimeConfig:", serverRuntimeConfig);
  console.log("From add bookmark, publicRuntimeConfig", publicRuntimeConfig);
  const axiosResponse = await axios.post(`${apiGetUrl()}/api/bookmarks`, bookmark);
  return axiosResponse.data;
};