import React, { useState } from "react";
import {
  Container, Card, CardHeader, CardBody,
  FormGroup, Label, Input, Button, Alert
} from "reactstrap";
import { getUserType } from "../services/userService"; // ← add this

function LoginPage({ onLogin }) {
  const [username,   setUsername]   = useState("");
  const [password,   setPassword]   = useState("");
  const [error,      setError]      = useState("");
  const [isLoading,  setIsLoading]  = useState(false);

  const handleLogin = async () => {
    if (!username.trim() || !password.trim()) {
      setError("Please enter username and password.");
      return;
    }

    setIsLoading(true);
    setError("");

    try {
      // Call the API to find out what type this username is
      const data = await getUserType(username.trim());

      // data.type will be "admin" or "resident" (whatever your API returns)
      onLogin({ username: username.trim(), userType: data });

    } catch (err) {
      if (err.response?.status === 404) {
        setError("Username not found.");
      } else {
        setError("Login failed. Please try again.");
      }
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Container
      className="d-flex justify-content-center align-items-center"
      style={{ minHeight: "100vh" }}
    >
      <Card style={{ width: "360px" }}>
        <CardHeader className="text-center fw-bold">
          Apartment Assist — Login
        </CardHeader>

        <CardBody>
          {error && <Alert color="danger">{error}</Alert>}

          <FormGroup>
            <Label>Username</Label>
            <Input
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              onKeyDown={(e) => e.key === "Enter" && handleLogin()}
              placeholder="Enter username"
              disabled={isLoading}
            />
          </FormGroup>

          <FormGroup>
            <Label>Password</Label>
            <Input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              onKeyDown={(e) => e.key === "Enter" && handleLogin()}
              placeholder="Enter password"
              disabled={isLoading}
            />
          </FormGroup>

          <Button color="primary" className="w-100"
            onClick={handleLogin} disabled={isLoading}>
            {isLoading ? "Logging in..." : "Login"}
          </Button>
        </CardBody>
      </Card>
    </Container>
  );
}

export default LoginPage;