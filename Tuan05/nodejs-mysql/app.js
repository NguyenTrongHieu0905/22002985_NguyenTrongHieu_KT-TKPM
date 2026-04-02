const express = require('express');
const mysql = require('mysql2');
const app = express();

const connection = mysql.createConnection({
  host: 'mysql',
  user: 'user',
  password: 'password',
  database: 'mydb'
});

app.get('/', (req, res) => {
  connection.query('SELECT 1 + 1 AS solution', (err, results) => {
    if (err) {
      return res.send('Error connecting to MySQL: ' + err.message);
    }
    res.send('Connected to MySQL! Result: ' + results[0].solution);
  });
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});