<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Student Login</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

<style>
:root {
  --primary: #6c63ff;
  --dark: #0f172a;
  --glass: rgba(255,255,255,0.15);
}

* {
  font-family: 'Poppins', sans-serif;
}

body {
  min-height: 100vh;
  background: radial-gradient(circle at top, #1e293b, #020617);
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
}

/* animated background glow */
body::before {
  content: "";
  position: absolute;
  width: 500px;
  height: 500px;
  background: var(--primary);
  filter: blur(180px);
  opacity: 0.35;
}

/* card */
.login-box {
  position: relative;
  width: 380px;
  padding: 40px;
  border-radius: 24px;
  background: var(--glass);
  backdrop-filter: blur(15px);
  box-shadow: 0 30px 80px rgba(0,0,0,0.6);
  color: #fff;
  animation: fadeUp 1s ease;
}

@keyframes fadeUp {
  from { opacity: 0; transform: translateY(40px); }
  to { opacity: 1; transform: translateY(0); }
}

.login-box h2 {
  text-align: center;
  font-weight: 600;
  margin-bottom: 30px;
}

/* floating input */
.input-group {
  position: relative;
  margin-bottom: 25px;
}

.input-group input {
  width: 100%;
  padding: 14px 45px;
  border-radius: 14px;
  border: none;
  outline: none;
  background: rgba(255,255,255,0.12);
  color: #fff;
}

.input-group input::placeholder {
  color: transparent;
}

.input-group label {
  position: absolute;
  top: 50%;
  left: 45px;
  color: #cbd5f5;
  font-size: 14px;
  transform: translateY(-50%);
  pointer-events: none;
  transition: 0.3s;
}

.input-group input:focus + label,
.input-group input:not(:placeholder-shown) + label {
  top: -8px;
  left: 15px;
  font-size: 12px;
  background: #020617;
  padding: 0 6px;
  border-radius: 6px;
}

.input-group i {
  position: absolute;
  top: 50%;
  left: 16px;
  transform: translateY(-50%);
  color: #c7d2fe;
}

/* button */
.btn-login {
  width: 100%;
  padding: 14px;
  border-radius: 16px;
  border: none;
  background: linear-gradient(135deg, #6c63ff, #8b5cf6);
  color: #fff;
  font-weight: 600;
  box-shadow: 0 10px 30px rgba(108,99,255,0.5);
  transition: all 0.4s ease;
}

.btn-login:hover {
  transform: translateY(-2px);
  box-shadow: 0 15px 40px rgba(108,99,255,0.8);
}

/* error */
.error {
  color: #fb7185;
  text-align: center;
  margin-bottom: 15px;
  font-size: 14px;
}

.footer {
  margin-top: 25px;
  text-align: center;
  font-size: 13px;
  color: #94a3b8;
}
</style>
</head>

<body>

<div class="login-box">

  <div class="error">
    ${login_fail}
  </div>

  <h2>LOGIN</h2>

  <form action="login" method="post">

    <div class="input-group">
      <i class="bi bi-person"></i>
      <input type="text" name="username" required placeholder="Username">
      <label>Username</label>
    </div>

    <div class="input-group">
      <i class="bi bi-lock"></i>
      <input type="password" name="password" required placeholder="Password">
      <label>Password</label>
    </div>

    <button class="btn-login">Login</button>

  </form>

  <div class="footer">
    Secure Access • © 2026
  </div>

</div>

</body>
</html>
