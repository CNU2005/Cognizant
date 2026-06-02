const container = document.querySelector("#eventContainer");
const loading = document.querySelector("#loading");

async function fetchEvents() {
    try {
        loading.style.display = "block";

        const response = await fetch(
            "https://jsonplaceholder.typicode.com/users"
        );

        const data = await response.json();

        loading.style.display = "none";

        data.forEach(event => {
            const div = document.createElement("div");
            div.textContent = event.name;
            container.appendChild(div);
        });
    } catch (error) {
        loading.style.display = "none";
        console.log("Error:", error);
    }
}

fetchEvents();