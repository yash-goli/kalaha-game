import React, {useEffect, useState} from "react";
import {Col, Container, Row} from "react-bootstrap";
import {KalahaBoard} from "../models/kalahaBoard";
import {getNewGameData, playGame} from "../services/services";
import {PlayersEnum} from "../models/constants";

export default function KalahaBoardApp() {
  const initialState = {playerTurn: '', pits: []};
  const [board, setBoard] = useState<KalahaBoard>(initialState);
  const [gameStart, setGameStart] = useState<boolean>(false);
  const [gameOver, setGameOver] = useState<boolean>(false);
  const [winnerPlayer, setWinnerPlayer] = useState<string>('');

  const onClickHandler = async (turn: string, pitIndex: number) => {
    const kalahaBoard = gameStart ? {...board} : {...board, playerTurn: turn}
    const newBoard = await playGame(kalahaBoard, pitIndex);
    setBoard(newBoard);
    setGameStart(true);
    checkWinner(newBoard);
  };

  const checkWinner = (newBoard: KalahaBoard) => {
    const playerAPits = newBoard.pits.slice(0, 6);
    const playerBPits = newBoard.pits.slice(7, 13);

    const isAPitsEmpty = playerAPits.every(item => item.stones === 0);
    const isBPitsEmpty = playerBPits.every(item => item.stones === 0);

    const isGameOver = isAPitsEmpty || isBPitsEmpty;
    setGameOver(isGameOver);

    const winnerPlayer = newBoard.pits[6].stones > newBoard.pits[13].stones ? PlayersEnum.PLAYER_A : PlayersEnum.PLAYER_B;
    setWinnerPlayer(winnerPlayer);
  };

  useEffect(() => {
    const foo = async () => {
      const board = await getNewGameData("A");
      setBoard(board);
      setGameStart(false);
    };

    foo();
  }, []);

  return <>
    <Container>
      <Row>
        <h2 className="text-center py-3">{gameOver ? `Player ${winnerPlayer} is winner of the game` : gameStart ? `Player ${board.playerTurn} your turn` : `Player A or Player B can start the game`}</h2>
      </Row>
    </Container>
    <Container>
      <Row>
        <h3 className="text-center py-2">Player A</h3>
      </Row>
    </Container>
    <Container className="kalaha-board shadow-sm rounded">
      <Row className="kalaha-board-row">
        <Col className="kalaha-board-column kalaha-board-pit-column">
          <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a kalaha-board-head-pit-player-a">
            <span className="kalaha-board-head-pit">{board.pits[6]?.stones || 0}</span>
          </div>
        </Col>
        <Col xs={8} className="kalaha-board-column">
          <Row className="kalaha-board-pit-row">
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[5].pitIndex)}>{board.pits[5]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[4].pitIndex)}>{board.pits[4]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[3].pitIndex)}>{board.pits[3]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[2].pitIndex)}>{board.pits[2]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[1].pitIndex)}>{board.pits[1]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-a" >
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('A', board.pits[0].pitIndex)}>{board.pits[0]?.stones || 0}</span>
              </div>
            </Col>
          </Row>
          <Row className="kalaha-board-pit-row">
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[7].pitIndex)}>{board.pits[7]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[8].pitIndex)}>{board.pits[8]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[9].pitIndex)}>{board.pits[9]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[10].pitIndex)}>{board.pits[10]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[11].pitIndex)}>{board.pits[11]?.stones || 0}</span>
              </div>
            </Col>
            <Col className="kalaha-board-pit-column">
              <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b">
                <span className="kalaha-board-cell-pit" onClick={() => onClickHandler('B', board.pits[12].pitIndex)}>{board.pits[12]?.stones || 0}</span>
              </div>
            </Col>
          </Row>
        </Col>
        <Col className="kalaha-board-column kalaha-board-pit-column">
          <div className="d-flex w-100 h-100 justify-content-center align-items-center kalaha-board-pit-player-b kalaha-board-head-pit-player-b">
            <span className="kalaha-board-head-pit">{board.pits[13]?.stones || 0}</span>
          </div>
        </Col>
      </Row>
    </Container>
    <Container>
      <Row>
        <h3 className="text-center py-3">Player B</h3>
      </Row>
    </Container>
  </>;
}