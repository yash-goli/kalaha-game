package com.game.bol.kalaha.services

import com.game.bol.kalaha.constants.PlayersEnum
import com.game.bol.kalaha.exceptions.KalahaApiException
import com.game.bol.kalaha.mocks.TestHelper
import com.game.bol.kalaha.models.KalahaBoard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class KalahaSowingServiceTest {
    private val kalahaSowingService = KalahaSowingService()

    @Test
    fun `Get exception with invalid pit`() {
        assertThrows<KalahaApiException> {
            val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
            kalahaSowingService.playerSowing(newBoard, 0)
        }
    }

    @Test
    fun `Get no changes on the board when pitIndex is head pit`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 7)
        assertThat(updatedBoard).isEqualTo(newBoard)
    }

    @Test
    fun `Get no changes on the board when pitIndex is for wrong player`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 10)
        assertThat(updatedBoard).isEqualTo(newBoard)
    }

    @Test
    fun `Get no changes on the board when pitIndex with zero stones selected`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.updatedBoard2())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 3)
        assertThat(updatedBoard).isEqualTo(newBoard)
    }

    @Test
    fun `when player A plays first move with pit 1, playerTurn will be with player A`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 1)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_A.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard1());
    }

    @Test
    fun `when player A plays first move with pit 3, playerTurn will be with player B`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 3)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_B.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard2());
    }

    @Test
    fun `when player B plays first move with pit 8, playerTurn will be with player B`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_B.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 8)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_B.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard3());
    }

    @Test
    fun `when player B plays first move with pit 11, playerTurn will be with player A`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_B.type, pits = TestHelper.newBoard())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 11)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_A.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard4());
    }

    @Test
    fun `when player A plays move with pit 6 with 8 stones, the stone should not add to head pit of player B`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.updatedBoard5())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 6)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_B.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard6());
    }

    @Test
    fun `when player B plays move with pit 13 with 8 stones, the stone should not add to head pit of player A`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_B.type, pits = TestHelper.updatedBoard7())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 13)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_A.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard8());
    }

    @Test
    fun `when player A last stone moves to its own empty pit, this stone and the opposite pit stones move to player A head pit`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_A.type, pits = TestHelper.updatedBoard9())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 3)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_B.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard10());
    }

    @Test
    fun `when player B last stone moves to its own empty pit, this stone and the opposite pit stones move to player B head pit`() {
        val newBoard = KalahaBoard(playerTurn = PlayersEnum.PLAYER_B.type, pits = TestHelper.updatedBoard11())
        val updatedBoard = kalahaSowingService.playerSowing(newBoard, 10)
        assertThat(updatedBoard.playerTurn).isEqualTo(PlayersEnum.PLAYER_A.type)
        assertThat(updatedBoard.pits).isEqualTo(TestHelper.updatedBoard12());
    }
}
