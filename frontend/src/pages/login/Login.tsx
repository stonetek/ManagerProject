import { useState } from "react";
import { FaConnectdevelop } from 'react-icons/fa';
import api from "../../services/api";
import { Link, useNavigate } from "react-router-dom";

import "./styles.css";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const history = useNavigate();

  async function login(e: any) {
    e.preventDefault();
    const data = {
      username,
      password
    };
    try {
      const response = await api.post('auth/signin', data);

      localStorage.setItem('username', username)
      localStorage.setItem('accessToken', response.data.token);

      history('/books')
    } catch (error) {
      alert('Login failed! Try again!');
    }
  }


  return (
    <div className="container">
      <div className="container-login">
        <div className="wrap-login">
          <form className="login-form">
            <span className="login-form-title"> Bem vindo </span>

            <span className="login-form-title">
            <FaConnectdevelop title="Project" color="#00008B"  className="w-24 h-24 ml-20 mt-5 mb-5"/>
            </span>

            <div className="wrap-input">
              <input
                className={username !== "" ? "has-val input" : "input"}
                type="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <span className="focus-input" data-placeholder="Email"></span>
            </div>

            <div className="wrap-input">
              <input
                className={password !== "" ? "has-val input" : "input"}
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <span className="focus-input" data-placeholder="Password"></span>
            </div>

            <div className="container-login-form-btn">
              <Link to={'/home'}>
                <button type="submit" className="login-form-btn">Login</button>
              </Link>
            </div>

            <div className="text-center">
              <span className="txt1">Não possui conta? </span>
              <a className="txt2" href="#">
                Criar conta
              </a>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;