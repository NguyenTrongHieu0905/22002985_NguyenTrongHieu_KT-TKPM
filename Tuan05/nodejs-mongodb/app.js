const express = require('express');
const mongoose = require('mongoose');
const app = express();

app.use(express.json());

// Connect to MongoDB
mongoose.connect('mongodb://mongodb:27017/testdb', {
  useNewUrlParser: true,
  useUnifiedTopology: true
});

// Create a simple schema
const Item = mongoose.model('Item', {
  name: String,
  created: { type: Date, default: Date.now }
});

// Routes
app.post('/items', async (req, res) => {
  const item = new Item({ name: req.body.name });
  await item.save();
  res.json(item);
});

app.get('/items', async (req, res) => {
  const items = await Item.find();
  res.json(items);
});

app.listen(3000, () => {
  console.log('Server running on port 3000');
});