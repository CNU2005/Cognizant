const events = [];

events.push(
    { name: "Baking", category: "Workshop" },
    { name: "Music Night", category: "Music" },
    { name: "Guitar Concert", category: "Music" },
    { name: "Painting", category: "Workshop" }
);

const musicEvents = events.filter(event => event.category === "Music");

console.log("Music Events:");
console.log(musicEvents);

const displayCards = events.map(
    event => `${event.category} on ${event.name}`
);

console.log("Display Cards:");
displayCards.forEach(card => console.log(card));