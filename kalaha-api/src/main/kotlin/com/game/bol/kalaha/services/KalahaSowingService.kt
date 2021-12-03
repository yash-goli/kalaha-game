package com.game.bol.kalaha.services

import com.game.bol.kalaha.constants.KalahaEnum
import com.game.bol.kalaha.constants.KalahaPlayerEnum
import com.game.bol.kalaha.constants.PlayersEnum
import com.game.bol.kalaha.exceptions.KalahaApiException
import com.game.bol.kalaha.models.KalahaBoard
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class KalahaSowingService {
    companion object {
        private val logger = LoggerFactory.getLogger(KalahaSowingService::class.java)
    }

    fun playerSowing(board: KalahaBoard, pitIndex: Int): KalahaBoard {

        if (pitIndex < 1 || pitIndex >= KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex()) throw KalahaApiException("Invalid pit Index!")

        if (KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex() == pitIndex || KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex() == pitIndex) return board

        if (board.playerTurn == PlayersEnum.PLAYER_A.type && pitIndex > KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex() ||
                board.playerTurn == PlayersEnum.PLAYER_B.type && pitIndex < KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex()) return board

        val pit = board.getPitValue(pitIndex)

        logger.info("selected pit: $pit")

        if (pit.stones == KalahaEnum.EMPTY_PIT.value) {
            return board
        }

        val stones = pit.stones

        pit.stones = KalahaEnum.EMPTY_PIT.value

        val currentIndex = sowingTowardsRightUntilLastButOne(stones, board, pitIndex)

        val lastIndex = sowingTowardsRightLastTurn(board, currentIndex)

        return if (board.playerTurn == PlayersEnum.PLAYER_A.type && lastIndex != KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex())
            board.copy(playerTurn = PlayersEnum.PLAYER_B.type)
        else if (board.playerTurn == PlayersEnum.PLAYER_B.type && lastIndex != KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex())
            board.copy(playerTurn = PlayersEnum.PLAYER_A.type)
        else board
    }

    fun sowingTowardsRightUntilLastButOne(stones: Int, board: KalahaBoard, pitIndex: Int): Int {
        var currentPitIndex = pitIndex

        (1 until stones).forEach { _ ->
            currentPitIndex = calculateNextPitIndex(board.playerTurn, currentPitIndex)

            val pit = board.getPitValue(currentPitIndex)
            pit.stones = pit.stones + 1
        }

        return currentPitIndex
    }

    fun sowingTowardsRightLastTurn(board: KalahaBoard, currentIndex: Int): Int {
        val lastIndex = calculateNextPitIndex(board.playerTurn, currentIndex)
        val lastPit = board.getPitValue(lastIndex)

        if ((board.playerTurn == PlayersEnum.PLAYER_A.type && lastIndex < KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex()) ||
                (board.playerTurn == PlayersEnum.PLAYER_B.type && lastIndex > KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex() && lastIndex < KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex())
        ) {
            val oppositePitIndex = KalahaPlayerEnum.TOTAL_PITS.calculateIndex() - lastIndex
            val oppositePit = board.getPitValue(oppositePitIndex)

            if (lastPit.stones == 0 && oppositePit.stones != 0) {
                val totalCollectedLastPitStones = oppositePit.stones + 1

                oppositePit.stones = 0
                lastPit.stones = 0

                val headPit = if (board.playerTurn == PlayersEnum.PLAYER_A.type) {
                    board.getPitValue(KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex())
                } else {
                    board.getPitValue(KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex())
                }

                headPit.stones = headPit.stones + totalCollectedLastPitStones
            } else {
                lastPit.stones = lastPit.stones + 1
            }
        } else {
            lastPit.stones = lastPit.stones + 1
        }

        return lastIndex
    }

    fun calculateNextPitIndex(playerTurn: String, pitIndex: Int): Int {
        val currentPitIndex = pitIndex % KalahaPlayerEnum.TOTAL_PITS.calculateIndex() + 1

        if (playerTurn == PlayersEnum.PLAYER_A.type && currentPitIndex == KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex() ||
                playerTurn == PlayersEnum.PLAYER_B.type && currentPitIndex == KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex()) {
            return currentPitIndex % KalahaPlayerEnum.TOTAL_PITS.calculateIndex() + 1
        }

        return currentPitIndex
    }
}