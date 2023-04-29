import Image from 'next/image'
import { Inter } from 'next/font/google'

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  return (
    <div>
      <h1>Welcome to Bookmark Application</h1>
      <button className={"btn btn-primary"}>Click</button>
    </div>
  )
}
