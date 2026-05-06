const express = require("express");
const app = express();

const tours = [
  { id: 1, name: "Da Nang", price: 100 },
  { id: 2, name: "Phu Quoc", price: 200 }
];

app.get("/tours", (req, res) => res.json(tours));

app.get("/tours/:id", (req, res) => {
  const tour = tours.find(t => t.id == req.params.id);
  if (!tour) return res.status(404).json({ message: "Not found" });
  res.json(tour);
});

app.listen(3002, () => console.log("Tour Service running 3002"));