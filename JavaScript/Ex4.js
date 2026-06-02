const events = [];

function addEvent(name, category, seats) {
    events.push({
        name,
        category,
        seats
    });
}

function registerUser(eventName) {
    const event = events.find(e => e.name === eventName);

    if (event && event.seats > 0) {
        event.seats--;
        console.log(`Registered for ${event.name}`);
    } else {
        console.log("Registration failed");
    }
}

function filterEventsByCategory(category, callback) {
    const filtered = events.filter(event => event.category === category);
    callback(filtered);
}

function createRegistrationTracker(category) {
    let totalRegistrations = 0;

    return function () {
        totalRegistrations++;
        console.log(
            `Total registrations for ${category}: ${totalRegistrations}`
        );
    };
}

addEvent("Community Meetup", "Social", 50);
addEvent("Tech Workshop", "Technology", 30);
addEvent("Coding Bootcamp", "Technology", 25);

registerUser("Tech Workshop");

const techTracker = createRegistrationTracker("Technology");

techTracker();
techTracker();
techTracker();

filterEventsByCategory("Technology", function (events) {
    console.log("Technology Events:");
    
    events.forEach(event => {
        console.log(`${event.name} - Seats: ${event.seats}`);
    });
});