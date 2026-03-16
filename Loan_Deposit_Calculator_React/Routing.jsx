import React from 'react'
import { Route, Routes } from 'react-router-dom'
import Home from './screens/Home'
import About from './screens/About'
import Services from './screens/Services.jsx'
import NetBanking from './screens/NetBanking'
import Contact from './screens/Contact'
import Loan from './components/Loan.jsx'
import Deposit from './components/Deposit.jsx'

function Routing() {
  return (
    <div>
        <Routes>
            <Route path="/" element={<Home/>}></Route>
            <Route path='/greet' element={<h1>Welcome to our Bank</h1>}></Route>
            <Route path='/about' element={<About/>}></Route>
            <Route path='/services' element={<Services/>}>
              <Route path="loan" element={<Loan/>}></Route>
            <Route path="deposit" element={<Deposit/>}></Route>
            </Route>
            <Route path='/login' element={<NetBanking/>}></Route>
            <Route path='/contact' element={<Contact/>}></Route>
            
        </Routes>
    </div>
  )
}

export default Routing