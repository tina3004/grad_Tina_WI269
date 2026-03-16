import React, { Component } from 'react'

export default class NetBanking extends Component {
  render() {
    return (
      <div>
        <h2>Please Login here</h2>
        <form>
          Username : <input></input><br></br>
          Password : <input></input><br></br>
          <br></br>
          <button>LOGIN</button>
          <button>RESET</button>
        </form>
      </div>
    )
  }
}
