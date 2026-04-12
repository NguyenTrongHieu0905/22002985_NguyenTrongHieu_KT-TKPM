import axios from "axios";
import { API } from "../api/api";

function Cart({ cart, setCart, user, setOrderId }) {

  const increase = (foodId) => {
    setCart(prev => ({
      ...prev,
      [foodId]: (prev[foodId] || 0) + 1
    }));
  };

  const decrease = (foodId) => {
    setCart(prev => {
      const newQty = prev[foodId] - 1;

      if (newQty <= 0) {
        const { [foodId]: _, ...rest } = prev;
        return rest;
      }

      return { ...prev, [foodId]: newQty };
    });
  };

  const remove = (foodId) => {
    setCart(prev => {
      const { [foodId]: _, ...rest } = prev;
      return rest;
    });
  };

  const createOrder = async () => {
    const res = await axios.post(API.ORDER + "/orders", {
      userId: user.id,
      items: cart
    });

    setOrderId(res.data.id);
    alert("Tạo order thành công");
  };

  return (
    <div className="card">
      <h2>🛒 Giỏ hàng</h2>

      {Object.keys(cart).length === 0 ? (
        <p>Chưa có món</p>
      ) : (
        Object.entries(cart).map(([foodId, qty]) => (
          <div key={foodId} style={{ marginBottom: "10px" }}>
            <span>Food ID: {foodId}</span>

            <button onClick={() => decrease(foodId)}>-</button>
            <span style={{ margin: "0 10px" }}>{qty}</span>
            <button onClick={() => increase(foodId)}>+</button>

            <button onClick={() => remove(foodId)} style={{ marginLeft: "10px" }}>
              Xóa
            </button>
          </div>
        ))
      )}

      {Object.keys(cart).length > 0 && (
        <button onClick={createOrder}>
          Tạo Order
        </button>
      )}
    </div>
  );
}

export default Cart;