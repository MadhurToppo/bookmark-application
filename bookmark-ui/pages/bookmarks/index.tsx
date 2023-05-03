import {GetServerSideProps, NextPage} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";
import Bookmarks from "@/components/Bookmarks";

interface HomeProps {
  bookmarksResponse: BookmarksResponse
}

const Home: NextPage<HomeProps> = (homeProps) => (
  <div>
    <Bookmarks bookmarksResponse={homeProps.bookmarksResponse}/>
  </div>
)

export const getServerSideProps: GetServerSideProps = async (context) => {
  const {page = 1} = context.query
  const bookmarksResponse = await fetchBookmarks(parseInt(String(page)))
  return {
    props: {
      bookmarksResponse: bookmarksResponse
    }
  }
}

export default Home
