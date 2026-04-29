import React from "react";
import { Card, CardBody } from "reactstrap";

function Header() {
  return (
    <Card className="mb-3">
      <CardBody>
        <h2 className="text-center">
          Apartment Management Admin Portal
        </h2>
      </CardBody>
    </Card>
  );
}

export default Header;