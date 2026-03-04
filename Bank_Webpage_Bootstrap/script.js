function display(page) {
    if (page == "home") {
        document.getElementById("content").innerHTML = `<h2>Welcome to our Bank</h2><p>We are committed to providing you with the best banking experience. Our services include savings accounts, checking accounts, loans, and investment options. We prioritize your financial well-being and strive to offer personalized solutions to meet your needs.</p>`;
    }
    else if (page == "about") {
        document.getElementById("content").innerHTML = `<h2>About Us</h2><p>Our bank has been serving customers for over 50 years. We are dedicated to building strong relationships with our clients and providing exceptional customer service. Our mission is to help you achieve your financial goals and secure your future.</p>`;
    }
    else if (page == "services") {
        document.getElementById("content").innerHTML = `<h2 class="text-center mb-4">Our Services</h2>

        <div class="row text-center">

            <div class="col-md-4">
                <button class="btn btn-primary w-100" onclick="display('loan')">
                    LOAN
                </button>
            </div>

            <div class="col-md-4">
                <button class="btn btn-success w-100" onclick="display('deposit')">
                    DEPOSIT
                </button>
            </div>

            <div class="col-md-4">
                <button class="btn btn-warning w-100" onclick="display('account')">
                    ACCOUNT OPENING
                </button>
            </div>

        </div>`;    
    }
    else if (page == "netbanking") {
        document.getElementById("content").innerHTML = `

        <h2 class="text-center mb-4">Account Access</h2>

        <div class="row justify-content-center">

        <div class="col-md-6">

        <div class="card p-4 shadow">

        <div class="text-center mb-3">
        <button class="btn btn-primary me-2" onclick="showLogin()">Login</button>
        <button class="btn btn-secondary" onclick="showSignup()">Signup</button>
        </div>

        <div id="accountForm">

        <!-- LOGIN FORM -->
        <form id="loginForm">

        <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" class="form-control">
        </div>

        <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>

        </form>

        </div>

        </div>

        <div class="text-center mt-3">
        <button class="btn btn-dark" onclick="display('services')">Back to Services</button>
        </div>

        </div>

        </div>
        `;
    }
    else if (page == "contact") {
        document.getElementById("content").innerHTML = `<h2>Contact Us</h2><p>If you have any questions or need assistance, please feel free to contact us. You can reach us at:</p><ul><li>Phone: 123-456-7890</li><li>Email: contact@ourbank.com</li></ul>`;
    }
    else if (page == "loan") {
        document.getElementById("content").innerHTML = `

        <h2>Loan Calculator</h2>

        <form class="mt-3">

        <div class="mb-3">
        <label class="form-label">Applicant Name</label>
        <input type="text" class="form-control" id="name">
        </div>

        <div class="mb-3">
        <label class="form-label">Loan Type</label>
        <select class="form-select" id="type" onchange="printInterest()">
        <option value="home">Home</option>
        <option value="car">Car</option>
        <option value="personal">Personal</option>
        </select>
        </div>

        <div class="mb-3">
        <label class="form-label">Interest</label>
        <input type="text" class="form-control" id="interest" disabled>
        </div>

        <div class="mb-3">
        <label class="form-label">Amount</label>
        <input type="number" class="form-control" id="amount">
        </div>

        <div class="mb-3">
        <label class="form-label">Duration (Years)</label>
        <input type="number" class="form-control" id="duration">
        </div>

        <button type="button" class="btn btn-primary" onclick="calculateEMI()">Calculate EMI</button>

        </form>

        <div id="invalid" class="text-danger mt-3"></div>
        <div id="result" class="mt-2"></div>

        <button class="btn btn-secondary mt-3" onclick="display('services')">Back</button>
        `;
    }

    else if (page == "deposit") {
        document.getElementById("content").innerHTML = `
        <h2>Deposit Calculator</h2>

        <div class="mb-3">
        <label class="form-label">Deposit Type</label>
        <select id="depositType" class="form-select">
        <option value="fixed">Fixed Deposit</option>
        <option value="recurring">Recurring Deposit</option>
        </select>
        </div>

        <div class="mb-3">
        <label class="form-label">Amount</label>
        <input type="number" id="depositAmount" class="form-control">
        </div>

        <div class="mb-3">
        <label class="form-label">Duration</label>
        <input type="number" id="depositDuration" class="form-control">
        </div>

        <button class="btn btn-success" onclick="calculateDeposit()">Calculate</button>

        <div id="depositResult" class="mt-3"></div>

        <button class="btn btn-secondary mt-3" onclick="display('services')">Back</button>
        `;
    }
    else if (page == "account") {
        document.getElementById("content").innerHTML = `<h2>Account Opening</h2><p>Open Savings or Current Account easily.</p><button onclick="display('services')">Back to Services</button>`;
    }
}

function calculateDeposit() {
    let type = document.getElementById("depositType").value;
    let amount = +document.getElementById("depositAmount").value;
    let duration = +document.getElementById("depositDuration").value;

    let result = document.getElementById("depositResult");

    if (amount <= 0 || duration <= 0) {
        result.innerHTML = "Please enter valid details";
        result.style.color = "red";
        return;
    }

    let maturity;
    let interestRate;

    if (type === "fixed") {
        interestRate = 7; // 7% FD
        maturity = amount + (amount * interestRate * duration / 100);
    }
    else {
        interestRate = 6; // 6% RD
        maturity = (amount * duration) + ((amount * duration) * interestRate / 100);
    }

    result.style.color = "green";
    result.innerHTML = "Maturity Amount: ₹ " + maturity.toFixed(2);
}

function calculateEMI() {
    let name = document.getElementById("name").value;
    let type = document.getElementById("type").value;
    let amount = +document.getElementById("amount").value;
    let duration = +document.getElementById("duration").value;
    let interest;
    let res = document.getElementById("result");
    let invalid = document.getElementById("invalid");

    if (name == "" || name.length < 3) {
        // alert("Please enter a valid name");
        invalid.innerHTML = "Please enter a valid name";
        return;
    }

    if (type === "car") {
        interest = 9;
        document.getElementById("interest").value = "9%";
    }
    else if (type === "home") {
        interest = 12;
        document.getElementById("interest").value = "12%";
    }
    else if (type === "personal") {
        interest = 15;
        document.getElementById("interest").value = "15%";
    }

    if (type === "car" && amount < 100000) {
        // alert("Car loan amount should be at least 1 lakh");
        invalid.innerHTML = "Car loan amount should be at least 1 lakh";
        return;
    }
    if (type === "home" && amount < 500000) {
        // alert("Home loan amount should be at least 5 lakhs");
        invalid.innerHTML = "Home loan amount should be at least 5 lakhs";
        return;
    }
    if (type === "personal" && amount < 10000) {
        // alert("Personal loan amount should be at least 10K");
        invalid.innerHTML = "Personal loan amount should be at least 10K";
        return;
    }

    if (type === "car" && duration < 7) {
        invalid.innerHTML = "Car loan duration should be at least 7 years";
        return;
    }
    if (type === "home" && duration < 30) {
        invalid.innerHTML = "Home loan duration should be at least 30 years";
        return;
    }
    if (type === "personal" && duration < 5) {
        invalid.innerHTML = "Personal loan duration should be at least 5 years";
        return;
    }

    let interestAmount = (amount * interest * duration) / 100;


    invalid.innerHTML = "";
    res.innerHTML = "The EMI is: " + interestAmount;
}

function printInterest() {
    let type = document.getElementById("type").value;
    let interest;

    if (type === "car") {
        interest = 9;
        document.getElementById("interest").value = "9%";
    }
    else if (type === "home") {
        interest = 12;
        document.getElementById("interest").value = "12%";
    }
    else if (type === "personal") {
        interest = 15;
        document.getElementById("interest").value = "15%";
    }
}

function showLogin() {
    document.getElementById("accountForm").innerHTML = `

<form>

<div class="mb-3">
<label class="form-label">Email</label>
<input type="email" class="form-control">
</div>

<div class="mb-3">
<label class="form-label">Password</label>
<input type="password" class="form-control">
</div>

<button type="submit" class="btn btn-primary w-100">Login</button>

</form>

`;
}

function showSignup() {
    document.getElementById("accountForm").innerHTML = `

<form>

<div class="mb-3">
<label class="form-label">Full Name</label>
<input type="text" class="form-control">
</div>

<div class="mb-3">
<label class="form-label">Email</label>
<input type="email" class="form-control">
</div>

<div class="mb-3">
<label class="form-label">Password</label>
<input type="password" class="form-control">
</div>

<div class="mb-3">
<label class="form-label">Confirm Password</label>
<input type="password" class="form-control">
</div>

<button type="submit" class="btn btn-success w-100">Create Account</button>

</form>

`;
}