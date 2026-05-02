import React, { useState } from "react";
import { Container, Row, Col, Card, CardHeader, ListGroup, ListGroupItem, Button } from "reactstrap";

import Dashboard    from "./Dashboard";
import UserCreation from "./UserCreation";
import RegisterUser from "./RegisterUser";

const MENU = ["Dashboard", "User Creation", "Register User"];

function AdminLayout({ onLogout }) {
  const [selectedPage, setSelectedPage] = useState("Dashboard");

  const renderPage = () => {
    if (selectedPage === "Dashboard")     return <Dashboard />;
    if (selectedPage === "User Creation") return <UserCreation />;
    if (selectedPage === "Register User") return <RegisterUser />;
  };

  return (
    <Container fluid className="p-3">

      {/* header */}
      <div className="mb-3 p-2 bg-dark text-white rounded d-flex justify-content-between">
        <span>Apartment Assist — Admin Portal</span>
        <Button size="sm" color="light" onClick={onLogout}>Logout</Button>
      </div>

      <Row>
        {/* sidebar */}
        <Col md="2">
          <Card>
            <CardHeader>Menu</CardHeader>
            <ListGroup flush>
              {MENU.map((item) => (
                <ListGroupItem
                  key={item} tag="button" action
                  active={selectedPage === item}
                  onClick={() => setSelectedPage(item)}
                >
                  {item}
                </ListGroupItem>
              ))}
            </ListGroup>
          </Card>
        </Col>

        {/* content */}
        <Col md="10">{renderPage()}</Col>
      </Row>
    </Container>
  );
}

export default AdminLayout;