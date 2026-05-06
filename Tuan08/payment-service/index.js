const express = require("express");
const app = express();
app.use(express.json());

app.post("/payments", (req, res) => {
  const { bookingId } = req.body;
  res.json({ status: "success", bookingId });
});

app.listen(3004, () => console.log("Payment Service running 3004"));