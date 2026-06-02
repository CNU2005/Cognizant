class Event {
    constructor(name, category, seats) {
        this.name = name;
        this.category = category;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability = function () {
    if (this.seats > 0) {
        return "Seats Available";
    } else {
        return "Event Full";
    }
};

const event1 = new Event("Community Meetup", "Social", 50);
const event2 = new Event("Tech Workshop", "Technology", 0);

console.log(event1.checkAvailability());
console.log(event2.checkAvailability());

Object.entries(event1).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});