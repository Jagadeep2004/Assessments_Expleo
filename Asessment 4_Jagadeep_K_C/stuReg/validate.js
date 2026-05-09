document.querySelector("form").addEventListener("submit", function(event) {
    let isValid = true;

    
    document.querySelectorAll("input, select").forEach(el => {
        el.style.border = "";
    });

    
    const fullName = document.getElementById("fullname").value.trim();
    if (fullName === "") {
        document.getElementById("fullname").style.border = "2px solid red";
        isValid = false;
    }

    
    const email = document.getElementById("email").value.trim();
    if (!(email.includes("@") && email.endsWith(".com"))) {
        document.getElementById("email").style.border = "2px solid red";
        isValid = false;
    }

    
    const dob = document.getElementById("dob").value;
    if (dob) {
        const dobDate = new Date(dob);
        const today = new Date();
        if (age < 17) {
            document.getElementById("dob").style.border = "2px solid red";
            isValid = false;
        }
    }


});