const form = document.querySelector("#registrationForm");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    document.querySelector("#nameError").textContent = "";
    document.querySelector("#emailError").textContent = "";
    document.querySelector("#eventError").textContent = "";

    const name = form.elements["name"].value.trim();
    const email = form.elements["email"].value.trim();
    const selectedEvent = form.elements["event"].value;

    let isValid = true;

    if (name === "") {
        document.querySelector("#nameError").textContent =
            "Name is required";
        isValid = false;
    }

    if (email === "") {
        document.querySelector("#emailError").textContent =
            "Email is required";
        isValid = false;
    }

    if (selectedEvent === "") {
        document.querySelector("#eventError").textContent =
            "Please select an event";
        isValid = false;
    }

    if (isValid) {
        console.log("Name:", name);
        console.log("Email:", email);
        console.log("Event:", selectedEvent);

        alert("Registration Successful!");
        form.reset();
    }
});