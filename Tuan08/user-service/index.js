const express = require("express");
const app = express();
app.use(express.json());

const users = [{ id: 1, username: "hieu", password: "123" }];

app.post("/login", (req, res) => {
  const { username, password } = req.body;
  const user = users.find(u => u.username === username && u.password === password);
  if (!user) return res.status(401).json({ message: "Invalid" });
  res.json(user);
});

app.get("/users/:id", (req, res) => {
  const user = users.find(u => u.id == req.params.id);
  if (!user) return res.status(404).json({ message: "Not found" });
  res.json(user);
});

app.listen(3001, () => console.log("User Service running 3001"));