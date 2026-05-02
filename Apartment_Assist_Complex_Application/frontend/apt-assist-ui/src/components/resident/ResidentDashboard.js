// components/resident/ResidentDashboard.jsx
import React from "react";
import { Card, CardHeader, CardBody } from "reactstrap";

function ResidentDashboard({ username }) {
  return (
    <Card>
      <CardHeader>Resident Dashboard</CardHeader>
      <CardBody>
        <p>Welcome, <strong>{username}</strong>!</p>
        <p>Your dashboard will show notices, maintenance status, etc.</p>
      </CardBody>
    </Card>
  );
}

export default ResidentDashboard;