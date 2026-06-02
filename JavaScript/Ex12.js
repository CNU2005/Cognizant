const form = document.querySelector("#registrationForm");
const message = document.querySelector("#message");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const userData = {
        name: document.querySelector("#name").value,
        email: document.querySelector("#email").value
    };

    message.textContent = "Submitting registration...";

    setTimeout(() => {
        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Registration failed");
            }
            return response.json();
        })
        .then(data => {
            message.textContent =
                "Registration successful!";
            console.log(data);
            form.reset();
        })
        .catch(error => {
            message.textContent =
                "Registration failed. Please try again.";
            console.log(error);
        });
    }, 2000);
});