import {GetServerSideProps, NextPage} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";
import Bookmarks from "@/components/Bookmarks";

interface HomeProps {
  bookmarksResponse: BookmarksResponse
}

const Home: NextPage<HomeProps> = (homeProps) => {
  return (
    <div>
      <h1>Welcome to Bookmark Application</h1>
      <Bookmarks bookmarksResponse={homeProps.bookmarksResponse}/>
    </div>
  )
}

export const getServerSideProps: GetServerSideProps = async (context) => {
  const {page = 1} = context.query
  const responseData = await fetchBookmarks(parseInt(String(page)))
  return {
    props: {
      bookmarksResponse: responseData
    }
  }
}

export default Home
