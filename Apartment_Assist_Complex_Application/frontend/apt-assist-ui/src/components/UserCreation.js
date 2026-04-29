import React from "react";
import {
  Card,
  CardHeader,
  CardBody,
  Row,
  Col,
  Form,
  FormGroup,
  Label,
  Input,
  Button
} from "reactstrap";

function UserCreation() {
  return (
    <Card>
      <CardHeader>User Creation</CardHeader>

      <CardBody>
        <Row className="mb-3">
          <Col md="8">
            <Label>User Number</Label>
            <Input placeholder="Enter User Number" />
          </Col>

          <Col md="4" className="mt-4">
            <Button color="primary" className="w-100">
              Search
            </Button>
          </Col>
        </Row>

        <Form>
          <Row>
            <Col md="6">
              <FormGroup>
                <Label>First Name</Label>
                <Input />
              </FormGroup>
            </Col>

            <Col md="6">
              <FormGroup>
                <Label>Last Name</Label>
                <Input />
              </FormGroup>
            </Col>

            <Col md="6">
              <FormGroup>
                <Label>Email</Label>
                <Input />
              </FormGroup>
            </Col>

            <Col md="6">
              <FormGroup>
                <Label>Phone</Label>
                <Input />
              </FormGroup>
            </Col>
          </Row>

          <Button color="success">Save</Button>
        </Form>
      </CardBody>
    </Card>
  );
}

export default UserCreation;