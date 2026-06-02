const events = [
    {
        name: "Community Meetup",
        date: "2026-06-10",
        seats: 50
    },
    {
        name: "Tech Workshop",
        date: "2026-05-20",
        seats: 30
    },
    {
        name: "Charity Run",
        date: "2026-06-15",
        seats: 0
    }
];

const today = new Date();

events.forEach(event => {
    const eventDate = new Date(event.date);

    if (eventDate >= today && event.seats > 0) {
        console.log(`Event: ${event.name} | Date: ${event.date} | Seats: ${event.seats}`);
    } else {
        console.log(`Hidden: ${event.name}`);
    }
});

function register(event) {
    try {
        if (event.seats <= 0) {
            throw new Error("No seats available");
        }

        event.seats--;
        console.log(`Successfully registered for ${event.name}`);
        console.log(`Remaining Seats: ${event.seats}`);
    } catch (error) {
        console.log(`Registration Failed: ${error.message}`);
    }
}

register(events[0]);
register(events[2]);