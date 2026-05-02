// components/resident/LodgeComplaint.jsx
import React, { useState } from "react";
import { Card, CardHeader, CardBody, FormGroup, Label, Input, Button } from "reactstrap";
import { toast } from "react-toastify";

function LodgeComplaint({ username }) {
  const [complaint, setComplaint] = useState("");

  const handleSubmit = () => {
    if (!complaint.trim()) {
      toast.warn("Please describe your complaint.");
      return;
    }
    // TODO: call your complaint API here
    toast.success("Complaint submitted successfully!");
    setComplaint("");
  };

  return (
    <Card>
      <CardHeader>Lodge a Complaint</CardHeader>
      <CardBody>
        <FormGroup>
          <Label>Describe your complaint</Label>
          <Input
            type="textarea"
            rows="5"
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Describe the issue..."
          />
        </FormGroup>
        <Button color="danger" onClick={handleSubmit}>
          Submit Complaint
        </Button>
      </CardBody>
    </Card>
  );
}

export default LodgeComplaint;