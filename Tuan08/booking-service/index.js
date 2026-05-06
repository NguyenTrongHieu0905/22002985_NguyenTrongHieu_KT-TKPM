const express = require("express");
const app = express();
app.use(express.json());

let bookings = [];

app.post("/bookings", (req, res) => {
  const booking = { id: bookings.length + 1, ...req.body };
  bookings.push(booking);
  res.json(booking);
});

app.listen(3003, () => console.log("Booking Service running 3003"));