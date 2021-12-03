import React from 'react';
import './App.css';
import KalahaBoardApp from "./components/KalahaBoardApp";
import {Container, Row} from "react-bootstrap";

function App() {
  return <>
    <Container fluid="lg">
      <Row className="my-5">
        <h1 className="text-center">Kalaha Game</h1>
      </Row>
      <Row className="justify-content-md-center">
        <KalahaBoardApp></KalahaBoardApp>
      </Row>
    </Container>
  </>;
}

export default App;
