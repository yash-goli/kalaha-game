package com.game.bol.kalaha.models

import com.game.bol.kalaha.constants.KalahaEnum
import com.game.bol.kalaha.constants.KalahaPlayerEnum
import com.game.bol.kalaha.exceptions.KalahaApiException

data class KalahaBoard(
        val playerTurn: String,
        val pits: List<KalahaPit> = listOf(
                (KalahaPlayerEnum.PLAYER_A_START_INDEX.calculateIndex()..KalahaPlayerEnum.PLAYER_A_END_INDEX.calculateIndex()).map { KalahaPit(it, KalahaEnum.PIT_STONES.value) },
                listOf(KalahaPit(KalahaPlayerEnum.PLAYER_A_PIT_HEAD_INDEX.calculateIndex(), 0)),
                (KalahaPlayerEnum.PLAYER_B_START_INDEX.calculateIndex()..KalahaPlayerEnum.PLAYER_B_END_INDEX.calculateIndex()).map { KalahaPit(it, KalahaEnum.PIT_STONES.value) },
                listOf(KalahaPit(KalahaPlayerEnum.PLAYER_B_PIT_HEAD_INDEX.calculateIndex(), 0))
        ).flatten()
) {
        fun getPitValue(pitIndex: Int): KalahaPit {
                try {
                        return this.pits[pitIndex - 1]
                } catch (e: Exception) {
                        throw KalahaApiException("Invalid pit Index!")
                }
        }
}
