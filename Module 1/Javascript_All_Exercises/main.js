// Exercise 1: Basics
console.log("Welcome to the Community Portal");
window.addEventListener('load', () => {
  alert("The page has fully loaded!");
});

// Event constructor function
function Event(name, date, totalSeats, category) {
  this.name = name;
  this.date = new Date(date);
  this.totalSeats = totalSeats;
  this.registered = 0;
  this.category = category || 'General';
}

Event.prototype.checkAvailability = function () {
  return this.totalSeats - this.registered > 0
    ? `${this.totalSeats - this.registered} seats available`
    : "Event Full";
};

// Create events array with Event instances only
const events = [
  new Event("Community Music Festival", "2025-06-20", 100, "Music"),
  new Event("Local Farmers Market", "2024-05-01", 30, "Food"),
  new Event("Tech Workshop", "2025-07-10", 0, "Workshop"),
  new Event("Neighborhood Cleanup", "2025-08-15", 20, "Community"),
  new Event("Baking Workshop", "2025-06-10", 20, "Workshop"),
  new Event("Jazz Night", "2025-06-22", 50, "Music"),
  new Event("Food Truck Festival", "2025-06-30", 100, "Food"),
  new Event("Rock Concert", "2025-07-05", 70, "Music"),
];

// Display upcoming events with seats in console
const today = new Date();

console.log("🎯 Upcoming Events with Available Seats:\n");

events.forEach(event => {
  if (event.date > today && event.totalSeats - event.registered > 0) {
    console.log(`📌 ${event.name} on ${event.date.toDateString()} — Seats: ${event.checkAvailability()}`);
  }
});

// Simulate registration function with error handling
function register(eventName) {
  try {
    const event = events.find(e => e.name === eventName);
    if (!event) throw new Error("Event not found.");
    if (event.date <= today) throw new Error("Cannot register for past events.");
    if (event.totalSeats - event.registered <= 0) throw new Error("No seats available.");

    event.registered++;
    console.log(`✅ Registered for ${event.name}. Remaining seats: ${event.checkAvailability()}`);
  } catch (error) {
    console.error(`❌ Registration failed: ${error.message}`);
  }
}

// Test registrations
register("Community Music Festival");
register("Tech Workshop");           // should fail
register("Local Farmers Market");    // should fail
register("Neighborhood Cleanup");    // should work

// -- Exercise 9: Search Bar + Category Filter --

// Create filter UI elements (search input + category dropdown)
const searchInput = document.createElement('input');
searchInput.type = 'text';
searchInput.placeholder = 'Search events by name...';
searchInput.style.margin = '10px';
searchInput.style.padding = '5px';
searchInput.style.width = '300px';

const categoryFilter = document.createElement('select');
categoryFilter.style.margin = '10px';
categoryFilter.style.padding = '5px';

const defaultOption = document.createElement('option');
defaultOption.value = '';
defaultOption.textContent = 'All Categories';
categoryFilter.appendChild(defaultOption);

// Dynamically get unique categories from events array
const categories = [...new Set(events.map(e => e.category))];
categories.forEach(cat => {
  const option = document.createElement('option');
  option.value = cat;
  option.textContent = cat;
  categoryFilter.appendChild(option);
});

// Add these elements before events container
document.body.insertBefore(searchInput, document.body.firstChild);
document.body.insertBefore(categoryFilter, document.body.firstChild);

// Container for events (already created in your code)
const eventsContainer = document.getElementById('eventsContainer');

// Filter and display events based on search & category
function filterAndDisplayEvents() {
  const searchTerm = searchInput.value.toLowerCase();
  const selectedCategory = categoryFilter.value;

  const filteredEvents = events.filter(event => {
    const matchesName = event.name.toLowerCase().includes(searchTerm);
    const matchesCategory = selectedCategory ? event.category === selectedCategory : true;
    return matchesName && matchesCategory;
  });

  displayEvents(filteredEvents);
}

// Add event listeners for live filtering
searchInput.addEventListener('input', filterAndDisplayEvents);
categoryFilter.addEventListener('change', filterAndDisplayEvents);

// Show all events initially
displayEvents(events);
