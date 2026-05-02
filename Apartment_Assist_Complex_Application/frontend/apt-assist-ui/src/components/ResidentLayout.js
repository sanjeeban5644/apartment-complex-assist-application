import React, { useState } from "react";
import { Container, Row, Col, Card, CardHeader, ListGroup, ListGroupItem, Button } from "reactstrap";

import ResidentDashboard from "./resident/ResidentDashboard";
import LodgeComplaint    from "./resident/LodgeComplaint";

const MENU = ["Dashboard", "Lodge Complaint"];

function ResidentLayout({ onLogout, username }) {
  const [selectedPage, setSelectedPage] = useState("Dashboard");

  const renderPage = () => {
    if (selectedPage === "Dashboard")      return <ResidentDashboard username={username} />;
    if (selectedPage === "Lodge Complaint") return <LodgeComplaint username={username} />;
  };

  return (
    <Container fluid className="p-3">

      {/* header */}
      <div className="mb-3 p-2 bg-primary text-white rounded d-flex justify-content-between">
        <span>Apartment Assist — Resident Portal</span>
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

export default ResidentLayout;