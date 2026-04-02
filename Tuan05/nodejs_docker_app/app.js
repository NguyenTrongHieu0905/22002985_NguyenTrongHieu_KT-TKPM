// app.js
const express = require('express');
const app = express();

// D?nh nghia route hi?n th? "Hello, Docker!"
app.get('/', (req, res) => {
  res.send('Hello, Docker!');
});

// Ch?y ?ng d?ng trˆn c?ng 3000
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`App is running on http://localhost:${PORT}`);
});