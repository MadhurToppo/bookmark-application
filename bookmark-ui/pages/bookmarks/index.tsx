import {GetServerSideProps, NextPage} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";

interface HomeProps {
  bookmarksResponse: BookmarksResponse
}

const Home: NextPage<HomeProps> = (props) => {
  return (
    <div>
      <h1>Welcome to Bookmark Application</h1>
      {props.bookmarksResponse.bookmarks.map(bookmark => <h2>{bookmark.name}</h2>)}
    </div>
  )
}

export const getServerSideProps: GetServerSideProps = async (context) => {
  const responseData = await fetchBookmarks()
  return {
    props: {
      bookmarksResponse: responseData
    }
  }
}

export default Home
