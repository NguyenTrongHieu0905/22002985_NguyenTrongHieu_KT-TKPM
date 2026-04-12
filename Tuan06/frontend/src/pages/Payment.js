import axios from "axios";
import { API } from "../api/api";

function Payment({ orderId, setOrderId, setCart, setReloadHistory }) {

  const pay = async () => {
    await axios.post(API.PAYMENT + "/payments", {
      orderId,
      method: "COD"
    });

    alert("Thanh toán thành công 🎉");

    // trigger reload history
    setReloadHistory(prev => !prev);

    // reset
    setOrderId(null);
    setCart({});
  };

  return (
    <div className="card">
      <h2>💳 Thanh toán</h2>
      <p>Order ID: #{orderId}</p>
      <button onClick={pay}>Thanh toán COD</button>
    </div>
  );
}

export default Payment;