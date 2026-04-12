import axios from "axios";
import { useState } from "react";
import { API } from "../api/api";

function Login({ setUser }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const register = async () => {
    await axios.post(API.USER + "/register", {
      username,
      password,
      role: "USER"
    });
    alert("Register thành công");
  };

  const login = async () => {
    const res = await axios.post(API.USER + "/login", {
      username,
      password
    });
    setUser(res.data);
  };

  return (
    <div className="container">
      <div className="card" style={{ maxWidth: 400, margin: "auto" }}>
        <h2>🔐 Login</h2>

        <input placeholder="Username" onChange={e => setUsername(e.target.value)} />
        <input type="password" placeholder="Password" onChange={e => setPassword(e.target.value)} />

        <div style={{ marginTop: 10 }}>
          <button onClick={register}>Register</button>
          <button onClick={login} style={{ marginLeft: 10 }}>Login</button>
        </div>
      </div>
    </div>
  );
}

export default Login;