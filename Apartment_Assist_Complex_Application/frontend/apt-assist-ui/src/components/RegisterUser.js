import React, { useState, useEffect } from "react";
import {
  Card, CardHeader, CardBody,
  Row, Col, FormGroup, Label, Input, Button
} from "reactstrap";
import { toast } from "react-toastify";
import { getUserTypes, saveUser, registerUser } from "../services/userService";

function RegisterUser() {
  const [uniqueNumber, setUniqueNumber] = useState("");
  const [userType,     setUserType]     = useState("");
  const [userTypes,    setUserTypes]    = useState([]);
  const [isLoading,    setIsLoading]    = useState(false);

  useEffect(() => {
    getUserTypes()
      .then((map) => {
        // map = { "OWNER": "Apartment Owner", "GUARD": "Security Guard", ... }
        // Convert to array: [{ code: "OWNER", desc: "Apartment Owner" }, ...]
        const converted = Object.entries(map).map(([code, desc]) => ({
          code: code,
          desc: desc,
        }));
        setUserTypes(converted);
      })
      .catch(() => toast.error("Could not load user types."));
  }, []);

  const handleSave = async () => {
  if (!uniqueNumber.trim() || !userType) {
    toast.warn("Please fill in all fields.");
    return;
  }
  setIsLoading(true);
  try {
    const payload = { uniqueNumber, userType };  // userType holds the CODE e.g. "OWNER"
    const response = await registerUser(payload);

    // ✅ Use apiData fields for toast
    toast.success(
      `${response.apiData.remarks} — Unique Number: ${response.apiData.uniqueUserNumber} (Registered To: ${response.apiData.registeredTo})`
    );

  } catch (err) {
    toast.error(err.response?.data?.message || "Registration failed.");
  } finally {
    setIsLoading(false);
  }
};


  return (
    <Card>
      <CardHeader>Register User</CardHeader>
      <CardBody>
        <Row>
          <Col md="6">
            <FormGroup>
              <Label>Unique User Number</Label>
              <Input
                value={uniqueNumber}
                onChange={(e) => setUniqueNumber(e.target.value)}
                placeholder="Enter unique number"
                disabled={isLoading}
              />
            </FormGroup>
          </Col>

          <Col md="6">
            <FormGroup>
              <Label>User Type</Label>
              <Input
                type="select"
                value={userType}
                onChange={(e) => setUserType(e.target.value)}
                disabled={isLoading}
              >
                <option value="">-- Select User Type --</option>
                {userTypes.map((t) => (
                  // value = code (what gets sent to backend)
                  // display = desc (what user sees)
                  <option key={t.code} value={t.code}>
                    {t.desc}
                  </option>
                ))}
              </Input>
            </FormGroup>
          </Col>
        </Row>

        <Button color="success" onClick={handleSave} disabled={isLoading}>
          {isLoading ? "Saving..." : "Register"}
        </Button>
      </CardBody>
    </Card>
  );
}

export default RegisterUser;