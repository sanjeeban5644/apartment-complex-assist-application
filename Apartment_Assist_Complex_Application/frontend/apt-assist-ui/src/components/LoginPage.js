import React, { useState } from "react";
import {
  Container, Card, CardHeader, CardBody,
  FormGroup, Label, Input, Button, Alert
} from "reactstrap";

function LoginPage({ onLogin }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error,    setError]    = useState("");

  const handleLogin = () => {
    if (username === "admin" && password === "admin") {
      onLogin();
    } else {
      setError("Invalid username or password.");
    }
  };

  return (
    <Container
      className="d-flex justify-content-center align-items-center"
      style={{ minHeight: "100vh" }}
    >
      <Card style={{ width: "360px" }}>
        <CardHeader className="text-center fw-bold">
          Apartment Assist — Admin Login
        </CardHeader>

        <CardBody>
          {error && <Alert color="danger">{error}</Alert>}

          <FormGroup>
            <Label>Username</Label>
            <Input
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              placeholder="Enter username"
            />
          </FormGroup>

          <FormGroup>
            <Label>Password</Label>
            <Input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Enter password"
            />
          </FormGroup>

          <Button color="primary" className="w-100" onClick={handleLogin}>
            Login
          </Button>
        </CardBody>
      </Card>
    </Container>
  );
}

export default LoginPage;