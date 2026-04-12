import { useEffect, useState } from "react";
import axios from "axios";
import { API } from "../api/api";

function History({ reloadHistory }) {
  const [history, setHistory] = useState([]);

  const fetchHistory = async () => {
    const res = await axios.get(API.PAYMENT + "/payments");
    setHistory(res.data);
  };

  useEffect(() => {
    fetchHistory();
  }, [reloadHistory]); // 👈 QUAN TRỌNG

  return (
    <div className="card">
      <h2>📜 Lịch sử thanh toán</h2>

      {history.length === 0 ? (
        <p>Chưa có đơn</p>
      ) : (
        history.map((p, index) => (
          <div key={index}>
            Order #{p.orderId} - {p.status}
          </div>
        ))
      )}
    </div>
  );
}

export default History;