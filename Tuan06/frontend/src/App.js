import { useState } from "react";
import Login from "./pages/Login";
import Foods from "./pages/Foods";
import Cart from "./pages/Cart";
import Payment from "./pages/Payment";
import History from "./pages/History";
import "./App.css";

function App() {
  const [user, setUser] = useState(null);
  const [cart, setCart] = useState({});
  const [orderId, setOrderId] = useState(null);
  const [reloadHistory, setReloadHistory] = useState(false);

  const addToCart = (food) => {
    setCart((prev) => ({
      ...prev,
      [food.id]: (prev[food.id] || 0) + 1,
    }));
  };

  if (!user) return <Login setUser={setUser} />;

  return (
    <div className="container">
      <h1 className="title">🍔 Mini Food App</h1>

      <Foods addToCart={addToCart} />
      <Cart cart={cart} setCart={setCart} user={user} setOrderId={setOrderId} />
      {orderId && (
        <Payment
          orderId={orderId}
          setOrderId={setOrderId}
          setCart={setCart}
          setReloadHistory={setReloadHistory}
        />
      )}
      <History reloadHistory={reloadHistory} />
    </div>
  );
}

export default App;
