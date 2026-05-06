const express = require("express");
const axios = require("axios");
const app = express();
app.use(express.json());

app.post("/book-tour", async (req, res) => {
  try {
    const { userId, tourId } = req.body;

    const userRes = await axios.get(`http://localhost:3001/users/${userId}`);
    const tourRes = await axios.get(`http://localhost:3002/tours/${tourId}`);

    const bookingRes = await axios.post("http://localhost:3003/bookings", {
      userId,
      tourId,
      price: tourRes.data.price
    });

    const paymentRes = await axios.post("http://localhost:3004/payments", {
      bookingId: bookingRes.data.id
    });

    res.json({
      message: "Booking success",
      booking: bookingRes.data,
      payment: paymentRes.data
    });

  } catch (err) {
    res.status(500).json({ message: "Error", error: err.message });
  }
});

app.listen(3000, () => console.log("Orchestrator running 3000"));