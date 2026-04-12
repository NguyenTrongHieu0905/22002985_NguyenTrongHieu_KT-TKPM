import axios from "axios";
import { useState, useEffect } from "react";
import { API } from "../api/api";

function Foods({ addToCart }) {
  const [foods, setFoods] = useState([]);

  useEffect(() => {
    axios.get(API.FOOD + "/foods")
      .then(res => setFoods(res.data))
      .catch(() => console.log("Food service chưa chạy"));
  }, []);

  return (
    <div className="card">
      <h2>🍜 Danh sách món</h2>

      <div className="food-grid">
        {foods.map(f => (
          <div className="food-card" key={f.id}>
            <img src={f.image} alt={f.name} className="food-img" />

            <div className="food-content">
              <h4>{f.name}</h4>
              <p className="price">{f.price} VND</p>
              <button onClick={() => addToCart(f)}>Thêm</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Foods;
