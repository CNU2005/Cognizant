const events = [
    {
        name: "Music Night",
        category: "Music",
        seats: 50
    },
    {
        name: "Baking Workshop",
        category: "Workshop",
        seats: 30
    },
    {
        name: "Guitar Concert",
        category: "Music",
        seats: 20
    }
];

function addEvent(
    name = "New Event",
    category = "General",
    seats = 0
) {
    events.push({ name, category, seats });
}

addEvent();

const { name, category, seats } = events[0];

console.log(name);
console.log(category);
console.log(seats);

const clonedEvents = [...events];

const musicEvents = clonedEvents.filter(
    event => event.category === "Music"
);

console.log(musicEvents);