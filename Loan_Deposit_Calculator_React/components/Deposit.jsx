import React, { useState } from "react";

function Deposit() {

  const [customerName, setCustomerName] = useState("");
  const [amount, setAmount] = useState("");
  const [interest, setInterest] = useState("");
  const [duration, setDuration] = useState("");
  const [finalAmount, setFinalAmount] = useState(null);
  const [error, setError] = useState("");

  const calculateDeposit = () => {

    const P = parseFloat(amount);
    const r = parseFloat(interest) / 100;
    const t = parseFloat(duration);

    if (customerName === "" || customerName.length < 3) {
      setError("Please enter a valid name");
      return;
    }

    if (!amount || P <= 0) {
      setError("Please enter a valid deposit amount");
      return;
    }

    if (!interest || r <= 0) {
      setError("Please enter a valid interest rate");
      return;
    }

    if (!duration || t <= 0) {
      setError("Please enter a valid duration");
      return;
    }

    const maturity = P * Math.pow((1 + r), t);

    setError("");
    setFinalAmount(maturity.toFixed(2));
  };

  return (
    <div>

      <h2>Deposit Calculator</h2>

      Customer Name:
      <input
        type="text"
        placeholder="Customer Name"
        onChange={(e) => setCustomerName(e.target.value)}
      />

      <br /><br />

      Deposit Amount:
      <input
        type="number"
        placeholder="Deposit Amount"
        onChange={(e) => setAmount(e.target.value)}
      />

      <br /><br />

      Interest Rate (%):
      <input
        type="number"
        placeholder="Interest Rate"
        onChange={(e) => setInterest(e.target.value)}
      />

      <br /><br />

      Duration (Years):
      <input
        type="number"
        placeholder="Duration"
        onChange={(e) => setDuration(e.target.value)}
      />

      <br /><br />

      <button onClick={calculateDeposit}>
        Calculate Maturity Amount
      </button>

      <br /><br />

      {error && (
        <p style={{ color: "red" }}>{error}</p>
      )}

      {finalAmount && (
        <h3>Final Amount: ₹{finalAmount}</h3>
      )}

    </div>
  );
}

export default Deposit;