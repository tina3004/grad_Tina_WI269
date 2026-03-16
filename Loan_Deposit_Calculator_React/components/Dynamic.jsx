import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function Dynamic() {
    const [count, setCount] = useState(1)
    const navigate = useNavigate()
    function increment(){
        
        if(count%5===0){
            navigate('/contact')
        }
        setCount(count+1)
    }
  return (
    <div>
        <h3>Dynamically moving to another component</h3>
        <h4>Count: {count}</h4>
        <center>
            <button onClick={increment}>CLICK</button>
        </center>
    </div>
  )
}

export default Dynamic