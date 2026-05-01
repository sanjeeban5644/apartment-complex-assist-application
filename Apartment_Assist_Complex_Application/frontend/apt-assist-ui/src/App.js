import React, { useState } from "react";
import { Container, Row, Col, Card, CardHeader, ListGroup, ListGroupItem } from "reactstrap";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import LoginPage    from "./components/LoginPage";
import Dashboard    from "./components/Dashboard";
import UserCreation from "./components/UserCreation";
import RegisterUser from "./components/RegisterUser";

const MENU = ["Dashboard", "User Creation", "Register User"];

function App() {
  const [isLoggedIn,   setIsLoggedIn]   = useState(false);
  const [selectedPage, setSelectedPage] = useState("Dashboard");

  // ── not logged in → show login page ──
  if (!isLoggedIn) {
    return (
      <>
        <LoginPage onLogin={() => setIsLoggedIn(true)} />
        <ToastContainer position="top-right" autoClose={4000} />
      </>
    );
  }

  // ── which component to show on the right ──
  const renderPage = () => {
    if (selectedPage === "Dashboard")    return <Dashboard />;
    if (selectedPage === "User Creation") return <UserCreation />;
    if (selectedPage === "Register User") return <RegisterUser />;
  };

  return (
    <Container fluid className="p-3">

      {/* top header */}
      <div className="mb-3 p-2 bg-dark text-white rounded">
        Apartment Assist — Admin Portal
      </div>

      <Row>
        {/* left menu */}
        <Col md="2">
          <Card>
            <CardHeader>Menu</CardHeader>
            <ListGroup flush>
              {MENU.map((item) => (
                <ListGroupItem
                  key={item}
                  tag="button"
                  action
                  active={selectedPage === item}
                  onClick={() => setSelectedPage(item)}
                >
                  {item}
                </ListGroupItem>
              ))}
            </ListGroup>
          </Card>
        </Col>

        {/* right content */}
        <Col md="10">
          {renderPage()}
        </Col>
      </Row>

      <ToastContainer position="top-right" autoClose={4000} />
    </Container>
  );
}

export default App;