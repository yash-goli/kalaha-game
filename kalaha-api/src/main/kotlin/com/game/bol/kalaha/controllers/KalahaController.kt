package com.game.bol.kalaha.controllers

import com.game.bol.kalaha.constants.PlayersEnum
import com.game.bol.kalaha.models.GamePlayRequestBody
import com.game.bol.kalaha.models.KalahaBoard
import com.game.bol.kalaha.services.KalahaSowingService
import org.springframework.beans.factory.annotation.Autowired
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/games/")
@CrossOrigin(origins = ["http://localhost:3000"])
@Api(value = "Kalaha Game", description = "Api for managing kalaha game", tags = ["game", "kalaha", "mancala"])
class KalahaController @Autowired constructor(val kalahaSowingService: KalahaSowingService) {

    companion object {
        private val logger = LoggerFactory.getLogger(KalahaController::class.java)
    }

    @ApiOperation(value = "Create new kalaha game", produces = "Application/JSON", response = KalahaBoard::class, httpMethod = "GET")
    @ApiResponses(value =
    [
        ApiResponse(code = 200, message = "Successfully created new kalaha game"),
        ApiResponse(code = 500, message = "Error creating kalaha board")
    ])
    @GetMapping("/{turn}")
    fun newGame(@PathVariable turn: String): KalahaBoard {
        logger.info("Started the game with player turn: $turn")
        val board = KalahaBoard(turn)
        logger.info("new board values: $board")
        return board
    }

    @ApiOperation(value = "Sowing for Kalaha game", produces = "Application/JSON", response = KalahaBoard::class, httpMethod = "PUT")
    @ApiResponses(value =
    [
        ApiResponse(code = 200, message = "Successfully returned the kalaha board with players move"),
    ])
    @PutMapping("/play")
    fun playGame(@Valid @RequestBody gamePlayRequestBody: GamePlayRequestBody): KalahaBoard {
        logger.info("Started the game with player turn: ${gamePlayRequestBody.board.playerTurn} on pit: ${gamePlayRequestBody.pit}")
        val kalahaBoard = kalahaSowingService.playerSowing(gamePlayRequestBody.board, gamePlayRequestBody.pit)
        logger.info("board with players turn: $kalahaBoard")
        return kalahaBoard
    }
}