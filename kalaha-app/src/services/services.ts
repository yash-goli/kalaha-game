import axios from "axios";
import {KalahaBoard} from "../models/kalahaBoard";

export async function getNewGameData(player: string): Promise<KalahaBoard> {
  try {
    const response = await axios.get<KalahaBoard>(`http://localhost:8080/v1/games/${player}`);
    return response.data;
  } catch(e) {
    console.log(e);
    throw e;
  }
}

export async function playGame(board: KalahaBoard, pit: number): Promise<KalahaBoard> {
  try {
    const response = await axios.put<KalahaBoard>(`http://localhost:8080/v1/games/play`, {board, pit});
    return response.data;
  } catch(e) {
    console.log(e);
    throw e;
  }
}