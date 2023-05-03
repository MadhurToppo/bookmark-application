import {GetServerSideProps, NextPage} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";
import Bookmarks from "@/components/Bookmarks";
import SearchForm from "@/components/SearchForm";

interface HomeProps {
  bookmarksResponse: BookmarksResponse;
  query: string
}

const Home: NextPage<HomeProps> = (homeProps) => (
  <div>
    <SearchForm/>
    <Bookmarks bookmarksResponse={homeProps.bookmarksResponse} query={homeProps.query}/>
  </div>
);

export const getServerSideProps: GetServerSideProps = async (context) => {
  const {page = 1, query = ""} = context.query;
  const bookmarksResponse = await fetchBookmarks(parseInt(String(page)), String(query));
  return {
    props: {
      bookmarksResponse,
      query
    }
  }
}

export default Home;
