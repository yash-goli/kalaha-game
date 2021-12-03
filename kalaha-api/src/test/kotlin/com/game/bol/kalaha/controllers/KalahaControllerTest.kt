package com.game.bol.kalaha.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.game.bol.kalaha.constants.PlayersEnum
import com.game.bol.kalaha.mocks.TestHelper
import com.game.bol.kalaha.models.GamePlayRequestBody
import com.game.bol.kalaha.models.KalahaBoard
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.put

@SpringBootTest
@AutoConfigureMockMvc
class KalahaControllerTest @Autowired constructor(
        val mockMvc: MockMvc,
        val objectMapper: ObjectMapper
        ) {

    @Test
    fun `Get kalaha new board`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
        mockMvc.get("/v1/games/A")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(newBoard))
                    }
                }
    }

    @Test
    fun `Get kalaha board updated with player turn`() {
        val newBoard = GamePlayRequestBody(board = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard()), pit = 2)
        val updatedBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_B.type, pits = TestHelper.playerTurn1())

        mockMvc.put("/v1/games/play") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBoard)
        }
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updatedBoard))
                    }
                }
    }

    @Test
    fun `Get kalaha Api Exception with invalid pit`() {
        val newBoard = GamePlayRequestBody(board = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard()), pit = 0)

        mockMvc.put("/v1/games/play") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBoard)
        }
                .andDo { print() }
                .andExpect {
                    status { is5xxServerError() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("exceptionType") {
                        value("KalahaApiException")
                    }
                    jsonPath("message") {
                        value("Invalid pit Index!")
                    }
                }
    }
}