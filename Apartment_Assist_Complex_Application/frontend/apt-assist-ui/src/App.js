import React, { useState } from "react";
import { Container, Row, Col } from "reactstrap";

import Header from "./components/Header";
import LeftMenu from "./components/LeftMenu";

import UserCreation from "./components/UserCreation";
import GenericPage from "./components/GenericPage";

function App() {
  const [selectedPage, setSelectedPage] =
    useState("User Creation");

  const renderPage = () => {
    if (selectedPage === "User Creation") {
      return <UserCreation />;
    }

    return (
      <GenericPage
        title={selectedPage}
        searchLabel={selectedPage + " Number"}
      />
    );
  };

  return (
    <Container fluid className="p-3">
      <Header />

      <Row>
        <Col md="3">
          <LeftMenu
            selectedPage={selectedPage}
            setSelectedPage={setSelectedPage}
          />
        </Col>

        <Col md="9">{renderPage()}</Col>
      </Row>
    </Container>
  );
}

export default App;