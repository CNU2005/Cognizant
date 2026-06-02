const form = document.querySelector("#registrationForm");
const message = document.querySelector("#message");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    console.log("Form submission started");

    const userData = {
        name: document.querySelector("#name").value,
        email: document.querySelector("#email").value
    };

    console.log("Collected User Data:", userData);

    debugger;

    fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    })
    .then(response => {
        console.log("Response Received:", response);

        if (!response.ok) {
            throw new Error("Request Failed");
        }

        return response.json();
    })
    .then(data => {
        console.log("Server Data:", data);
        message.textContent = "Registration Successful";
    })
    .catch(error => {
        console.error("Error:", error);
        message.textContent = "Registration Failed";
    });
});