import {GetServerSideProps, NextPage} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";

interface HomeProps {
  bookmarks: BookmarksResponse
}

const Home: NextPage<HomeProps> = (props) => {
  return (
    <div>
      <h1>Welcome to Bookmark Application</h1>
      {props.bookmarks.data.map(bookmark => <h2>{bookmark.name}</h2>)}
    </div>
  )
}

export const getServerSideProps: GetServerSideProps = async (context) => {
  const bookmarks = await fetchBookmarks()
  return {
    props: {
      bookmarks
    }
  }
}

export default Home
