import React, { useState } from "react";

function Loan() {

  const [customerName, setCustomerName] = useState("");
  const [loanType, setLoanType] = useState("");
  const [amount, setAmount] = useState("");
  const [duration, setDuration] = useState("");
  const [interest, setInterest] = useState("");
  const [emi, setEmi] = useState(null);
  const [error, setError] = useState("");

  const loanTypeHandle = (type) => {

    setLoanType(type);

    if (type === "car") {
      setInterest(9);
    } 
    else if (type === "home") {
      setInterest(12);
    } 
    else if (type === "personal") {
      setInterest(15);
    }
  };

  const calculateLoan = () => {

    const P = parseFloat(amount);
    const r = parseFloat(interest) / 100;
    const t = parseFloat(duration);

    if (customerName === "" || customerName.length < 3) {
      setError("Please enter a valid name");
      return;
    }

    if (!loanType) {
      setError("Please select loan type");
      return;
    }

    if (loanType === "car" && P < 100000) {
      setError("Car loan amount should be at least 1 lakh");
      return;
    }

    if (loanType === "home" && P < 500000) {
      setError("Home loan amount should be at least 5 lakhs");
      return;
    }

    if (loanType === "personal" && P < 10000) {
      setError("Personal loan amount should be at least 10K");
      return;
    }

    if (loanType === "car" && t < 7) {
      setError("Car loan duration should be at least 7 years");
      return;
    }

    if (loanType === "home" && t < 30) {
      setError("Home loan duration should be at least 30 years");
      return;
    }

    if (loanType === "personal" && t < 5) {
      setError("Personal loan duration should be at least 5 years");
      return;
    }

    const interestAmount = (P * r * t);

    setError("");
    setEmi(interestAmount.toFixed(2));
  };

  return (
    <div>

      <h2>Loan Calculator</h2>

      Customer Name:
      <input
        type="text"
        placeholder="Customer Name"
        onChange={(e) => setCustomerName(e.target.value)}
      />

      <br /><br />

      Loan Type:
      <select onChange={(e) => loanTypeHandle(e.target.value)}>
        <option value="">Select Loan Type</option>
        <option value="car">Car Loan</option>
        <option value="home">Home Loan</option>
        <option value="personal">Personal Loan</option>
      </select>

      <br /><br />

      Loan Amount:
      <input
        type="number"
        placeholder="Loan Amount"
        onChange={(e) => setAmount(e.target.value)}
      />

      <br /><br />

      Interest Rate:
      <input
        type="text"
        value={interest}
        readOnly
      />

      <br /><br />

      Duration (Years):
      <input
        type="number"
        placeholder="Duration"
        onChange={(e) => setDuration(e.target.value)}
      />

      <br /><br />

      <button onClick={calculateLoan}>
        Calculate Loan
      </button>

      <br /><br />

      {error && (
        <p style={{color:"red"}}>{error}</p>
      )}

      {emi && (
        <h3>Loan Interest Amount: ₹{emi}</h3>
      )}

    </div>
  );
}

export default Loan;