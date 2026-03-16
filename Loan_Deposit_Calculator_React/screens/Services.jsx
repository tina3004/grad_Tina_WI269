import React from 'react'
import Loan from '../components/Loan'
import Deposit from '../components/Deposit'
import { Link, Outlet } from 'react-router-dom'

function Services() {
  return (
    <div>
        Our Services
        <br /> <br />
      <Link to="loan"> 
        <button>Loan Calculator</button>
      </Link>
      <Link to="deposit">
        <button>Deposit Calculator</button>
      </Link>
      <Outlet />
    </div>
  )
}

export default Services