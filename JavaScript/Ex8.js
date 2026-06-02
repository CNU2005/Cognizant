const events = [
    { name: "Music Night", category: "Music", seats: 5 },
    { name: "Guitar Concert", category: "Music", seats: 10 },
    { name: "Baking Workshop", category: "Workshop", seats: 3 }
];

const container = document.querySelector("#eventContainer");
const categoryFilter = document.querySelector("#categoryFilter");
const searchBox = document.querySelector("#searchBox");

function displayEvents(eventList) {
    container.innerHTML = "";

    eventList.forEach((event, index) => {
        const card = document.createElement("div");

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="register(${index})">
                Register
            </button>
            <hr>
        `;

        container.appendChild(card);
    });
}

function register(index) {
    if (events[index].seats > 0) {
        events[index].seats--;
        displayEvents(events);
        alert(`Registered for ${events[index].name}`);
    } else {
        alert("No seats available");
    }
}

categoryFilter.onchange = function () {
    const selectedCategory = categoryFilter.value;

    if (selectedCategory === "All") {
        displayEvents(events);
    } else {
        const filteredEvents = events.filter(
            event => event.category === selectedCategory
        );

        displayEvents(filteredEvents);
    }
};

searchBox.addEventListener("keydown", function () {
    const searchText = searchBox.value.toLowerCase();

    const filteredEvents = events.filter(event =>
        event.name.toLowerCase().includes(searchText)
    );

    displayEvents(filteredEvents);
});

displayEvents(events);