import React from "react";
import { Row, Col, Card, CardBody } from "reactstrap";

const stats = [
  { label: "Total Residents",   value: 124 },
  { label: "Open Complaints",   value: 8   },
  { label: "Vacant Apartments", value: 3   },
  { label: "Vendor Requests",   value: 5   },
];

function Dashboard() {
  return (
    <>
      <h5 className="mb-4">Dashboard</h5>
      <Row>
        {stats.map((s) => (
          <Col md="3" key={s.label}>
            <Card className="text-center mb-3">
              <CardBody>
                <h3>{s.value}</h3>
                <small className="text-muted">{s.label}</small>
              </CardBody>
            </Card>
          </Col>
        ))}
      </Row>
    </>
  );
}

export default Dashboard;