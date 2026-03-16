import React from 'react'
import { Link } from 'react-router-dom'

function Menu() {
  return (
    <div className="menu">
      <Link to={'/'}>Home</Link> |
      <Link to={'/about'}>About Us</Link> |
      <Link to={'/services'}>Services</Link> |
      <Link to={'/login'}>NetBanking</Link> |
      <Link to={'/contact'}>Contact Us</Link>
    </div>
  )
}

export default Menu