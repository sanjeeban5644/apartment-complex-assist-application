import React, { useState } from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import LoginPage      from "./components/LoginPage";
import AdminLayout    from "./components/AdminLayout";    // ← extracted (see below)
import ResidentLayout from "./components/ResidentLayout"; // ← new

function App() {
  // null means not logged in
  // { username: "...", userType: "admin" | "resident" }
  const [user, setUser] = useState(null);

  const handleLogin = ({ username, userType }) => {
    setUser({ username, userType });
  };

  const handleLogout = () => setUser(null);

  // ── not logged in ──
  if (!user) {
    return (
      <>
        <LoginPage onLogin={handleLogin} />
        <ToastContainer position="top-right" autoClose={4000} />
      </>
    );
  }

  // ── logged in → pick layout by type ──
  return (
    <>
      {user.userType === "ADMIN"    && <AdminLayout    onLogout={handleLogout} />}
      {user.userType === "OWNER" && <ResidentLayout onLogout={handleLogout} username={user.username} />}
       {user.userType !== "ADMIN" && user.userType !== "OWNER" && (
      <div className="p-4 text-danger">
        Unknown user type: "{user.userType}" — please contact support.
      </div>
    )}
      <ToastContainer position="top-right" autoClose={4000} />
    </>
  );
}

export default App;