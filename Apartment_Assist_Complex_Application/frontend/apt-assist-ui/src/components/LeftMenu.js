import React from "react";
import { Card, CardHeader, ListGroup, ListGroupItem } from "reactstrap";

function LeftMenu({ selectedPage, setSelectedPage }) {
  const menuItems = [
    "User Creation",
    "Register User",
    "Update Apartment",
    "Update Parking",
    "Update Community Hall",
    "Resident Complaints",
    "Vendor Requests"
  ];

  return (
    <Card>
      <CardHeader>Admin</CardHeader>

      <ListGroup flush>
        {menuItems.map((item, index) => (
          <ListGroupItem
            key={index}
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
  );
}

export default LeftMenu;