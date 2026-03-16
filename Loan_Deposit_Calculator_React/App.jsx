import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import Header from './shared/Header'
import Footer from './shared/Footer'
import Menu from './screens/Menu'
import Home from './screens/Home'
import Routing from './Routing'
import './index.css'


function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="app-container">

      <div className="header">
        <Header />
      </div>

      <div className="content">
        <Routing />
      </div>

      <div className="footer">
        <Footer />
      </div>

    </div>
  )
}

export default App
