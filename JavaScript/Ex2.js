const eventName = "Community Meetup";
const eventDate = "10-June-2026";

let availableSeats = 50;

console.log(
    `Event: ${eventName}
Date: ${eventDate}
Available Seats: ${availableSeats}`
);

availableSeats--;

console.log(`Seats remaining after registration: ${availableSeats}`);