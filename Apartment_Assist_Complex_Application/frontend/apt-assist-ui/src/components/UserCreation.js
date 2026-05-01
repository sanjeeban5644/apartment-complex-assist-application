import React, { useState } from "react";
import {
  Card, CardHeader, CardBody,
  Row, Col, FormGroup, Label, Input, Button
} from "reactstrap";
import { toast } from "react-toastify";
import { getUser, saveUser } from "../services/userService";

function UserCreation() {
  // ── state ──────────────────────────────────────────────
  const [uniqueNumber, setUniqueNumber] = useState("");
  const [isExisting,   setIsExisting]   = useState(false);
  const [isLoading,    setIsLoading]    = useState(false);

  const [formData, setFormData] = useState({
    firstName: "",
    lastName:  "",
    email:     "",
    mobile:    "",
    dob:       "",
    aadhar:    "",
    address:   "",
  });

  // ── helpers ─────────────────────────────────────────────
  const handleChange = (field, value) => {
    setFormData((prev) => ({ ...prev, [field]: value }));
  };

  // ── search ──────────────────────────────────────────────
  const handleSearch = async () => {
    if (!uniqueNumber.trim()) {
      toast.warn("Please enter a unique number.");
      return;
    }
    setIsLoading(true);
    try {
      const data = await getUser(uniqueNumber.trim());
      setFormData(data);
      setIsExisting(true);
      toast.success("User found!");
    } catch (err) {
      if (err.response?.status === 404) {
        setFormData({ firstName:"", lastName:"", email:"",
                      mobile:"", dob:"", aadhar:"", address:"" });
        setIsExisting(false);
        toast.info("User not found. Fill in details to create.");
      } else {
        toast.error("Something went wrong.");
      }
    } finally {
      setIsLoading(false);
    }
  };

  // ── save ────────────────────────────────────────────────
  const handleSave = async () => {
    setIsLoading(true);
    try {
      const payload = {
        ...formData,
        ...(isExisting && { uniqueNumber }),
      };
      const response = await saveUser(payload);
      toast.success(`${response.message} — Number: ${response.userNumber}`);
      if (!isExisting) {
        setUniqueNumber(response.userNumber);
        setIsExisting(true);
      }
    } catch (err) {
      toast.error(err.response?.data?.message || "Save failed.");
    } finally {
      setIsLoading(false);
    }
  };

  // ── render ──────────────────────────────────────────────
  return (
    <Card>
      <CardHeader>
        User Creation
        {isExisting && (
          <span className="ms-2 badge bg-success" style={{ fontSize: "11px" }}>
            Existing User
          </span>
        )}
      </CardHeader>

      <CardBody>
        {/* Search row */}
        <Row className="mb-4">
          <Col md="8">
            <Label>Unique User Number</Label>
            <Input
              value={uniqueNumber}
              onChange={(e) => setUniqueNumber(e.target.value)}
              onKeyDown={(e) => e.key === "Enter" && handleSearch()}
              placeholder="Enter unique number"
              disabled={isLoading}
            />
          </Col>
          <Col md="4" className="mt-4">
            <Button
              color="primary"
              className="w-100"
              onClick={handleSearch}
              disabled={isLoading}
            >
              {isLoading ? "Searching..." : "Search"}
            </Button>
          </Col>
        </Row>

        {/* Form fields */}
        <Row>
          <Col md="6">
            <FormGroup>
              <Label>First Name</Label>
              <Input value={formData.firstName}
                onChange={(e) => handleChange("firstName", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>Last Name</Label>
              <Input value={formData.lastName}
                onChange={(e) => handleChange("lastName", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>Email</Label>
              <Input type="email" value={formData.email}
                onChange={(e) => handleChange("email", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>Mobile</Label>
              <Input value={formData.mobile}
                onChange={(e) => handleChange("mobile", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>Date of Birth</Label>
              <Input type="date" value={formData.dob}
                onChange={(e) => handleChange("dob", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>Aadhar Number</Label>
              <Input value={formData.aadhar}
                onChange={(e) => handleChange("aadhar", e.target.value)} />
            </FormGroup>
          </Col>

          <Col md="12">
            <FormGroup>
              <Label>Address</Label>
              <Input value={formData.address}
                onChange={(e) => handleChange("address", e.target.value)} />
            </FormGroup>
          </Col>
        </Row>

        <Button color="success" onClick={handleSave} disabled={isLoading}>
          {isLoading ? "Saving..." : isExisting ? "Update" : "Save"}
        </Button>
      </CardBody>
    </Card>
  );
}

export default UserCreation;