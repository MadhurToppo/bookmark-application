import '@/styles/globals.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import type { AppProps } from 'next/app'
import NavBar from "@/components/NavBar";

export default function App({ Component, pageProps }: AppProps) {
  return (
    <div>
      <NavBar/>
      <main>
        <Component {...pageProps} />
      </main>
    </div>

  )
}
