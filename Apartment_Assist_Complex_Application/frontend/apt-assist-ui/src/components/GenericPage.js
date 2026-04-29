import React from "react";
import {
  Card,
  CardHeader,
  CardBody,
  Row,
  Col,
  Label,
  Input,
  Button
} from "reactstrap";

function GenericPage({ title, searchLabel }) {
  return (
    <Card>
      <CardHeader>{title}</CardHeader>

      <CardBody>
        <Row className="mb-3">
          <Col md="8">
            <Label>{searchLabel}</Label>
            <Input placeholder={"Enter " + searchLabel} />
          </Col>

          <Col md="4" className="mt-4">
            <Button color="primary" className="w-100">
              Search
            </Button>
          </Col>
        </Row>

        <Row>
          <Col md="6">
            <Label>Name</Label>
            <Input />
          </Col>

          <Col md="6">
            <Label>Status</Label>
            <Input />
          </Col>
        </Row>

        <Button color="success" className="mt-3">
          Save
        </Button>
      </CardBody>
    </Card>
  );
}

export default GenericPage;