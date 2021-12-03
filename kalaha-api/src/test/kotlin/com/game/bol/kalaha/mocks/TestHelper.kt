package com.game.bol.kalaha.mocks

import com.game.bol.kalaha.models.KalahaPit

class TestHelper {
    companion object{
        fun newBoard(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 6),
                    KalahaPit(2, 6),
                    KalahaPit(3, 6),
                    KalahaPit(4, 6),
                    KalahaPit(5, 6),
                    KalahaPit(6, 6),
                    KalahaPit(7, 0),
                    KalahaPit(8, 6),
                    KalahaPit(9, 6),
                    KalahaPit(10, 6),
                    KalahaPit(11, 6),
                    KalahaPit(12, 6),
                    KalahaPit(13, 6),
                    KalahaPit(14, 0),
            )
        }

        fun playerTurn1(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 6),
                    KalahaPit(2, 0),
                    KalahaPit(3, 7),
                    KalahaPit(4, 7),
                    KalahaPit(5, 7),
                    KalahaPit(6, 7),
                    KalahaPit(7, 1),
                    KalahaPit(8, 7),
                    KalahaPit(9, 6),
                    KalahaPit(10, 6),
                    KalahaPit(11, 6),
                    KalahaPit(12, 6),
                    KalahaPit(13, 6),
                    KalahaPit(14, 0),
            )
        }

        fun updatedBoard1(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 0),
                    KalahaPit(2, 7),
                    KalahaPit(3, 7),
                    KalahaPit(4, 7),
                    KalahaPit(5, 7),
                    KalahaPit(6, 7),
                    KalahaPit(7, 1),
                    KalahaPit(8, 6),
                    KalahaPit(9, 6),
                    KalahaPit(10, 6),
                    KalahaPit(11, 6),
                    KalahaPit(12, 6),
                    KalahaPit(13, 6),
                    KalahaPit(14, 0),
            )
        }

        fun updatedBoard2(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 6),
                    KalahaPit(2, 6),
                    KalahaPit(3, 0),
                    KalahaPit(4, 7),
                    KalahaPit(5, 7),
                    KalahaPit(6, 7),
                    KalahaPit(7, 1),
                    KalahaPit(8, 7),
                    KalahaPit(9, 7),
                    KalahaPit(10, 6),
                    KalahaPit(11, 6),
                    KalahaPit(12, 6),
                    KalahaPit(13, 6),
                    KalahaPit(14, 0),
            )
        }

        fun updatedBoard3(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 6),
                    KalahaPit(2, 6),
                    KalahaPit(3, 6),
                    KalahaPit(4, 6),
                    KalahaPit(5, 6),
                    KalahaPit(6, 6),
                    KalahaPit(7, 0),
                    KalahaPit(8, 0),
                    KalahaPit(9, 7),
                    KalahaPit(10, 7),
                    KalahaPit(11, 7),
                    KalahaPit(12, 7),
                    KalahaPit(13, 7),
                    KalahaPit(14, 1),
            )
        }

        fun updatedBoard4(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 7),
                    KalahaPit(2, 7),
                    KalahaPit(3, 7),
                    KalahaPit(4, 6),
                    KalahaPit(5, 6),
                    KalahaPit(6, 6),
                    KalahaPit(7, 0),
                    KalahaPit(8, 6),
                    KalahaPit(9, 6),
                    KalahaPit(10, 6),
                    KalahaPit(11, 0),
                    KalahaPit(12, 7),
                    KalahaPit(13, 7),
                    KalahaPit(14, 1),
            )
        }

        fun updatedBoard5(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 1),
                    KalahaPit(2, 8),
                    KalahaPit(3, 8),
                    KalahaPit(4, 7),
                    KalahaPit(5, 0),
                    KalahaPit(6, 8),
                    KalahaPit(7, 2),
                    KalahaPit(8, 7),
                    KalahaPit(9, 7),
                    KalahaPit(10, 0),
                    KalahaPit(11, 8),
                    KalahaPit(12, 8),
                    KalahaPit(13, 7),
                    KalahaPit(14, 1),
            )
        }

        fun updatedBoard6(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 2),
                    KalahaPit(2, 8),
                    KalahaPit(3, 8),
                    KalahaPit(4, 7),
                    KalahaPit(5, 0),
                    KalahaPit(6, 0),
                    KalahaPit(7, 3),
                    KalahaPit(8, 8),
                    KalahaPit(9, 8),
                    KalahaPit(10, 1),
                    KalahaPit(11, 9),
                    KalahaPit(12, 9),
                    KalahaPit(13, 8),
                    KalahaPit(14, 1),
            )
        }

        fun updatedBoard7(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 7),
                    KalahaPit(2, 7),
                    KalahaPit(3, 0),
                    KalahaPit(4, 8),
                    KalahaPit(5, 8),
                    KalahaPit(6, 7),
                    KalahaPit(7, 1),
                    KalahaPit(8, 1),
                    KalahaPit(9, 8),
                    KalahaPit(10, 8),
                    KalahaPit(11, 7),
                    KalahaPit(12, 0),
                    KalahaPit(13, 8),
                    KalahaPit(14, 2),
            )
        }

        fun updatedBoard8(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 8),
                    KalahaPit(2, 8),
                    KalahaPit(3, 1),
                    KalahaPit(4, 9),
                    KalahaPit(5, 9),
                    KalahaPit(6, 8),
                    KalahaPit(7, 1),
                    KalahaPit(8, 2),
                    KalahaPit(9, 8),
                    KalahaPit(10, 8),
                    KalahaPit(11, 7),
                    KalahaPit(12, 0),
                    KalahaPit(13, 0),
                    KalahaPit(14, 3),
            )
        }

        fun updatedBoard9(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 0),
                    KalahaPit(2, 0),
                    KalahaPit(3, 1),
                    KalahaPit(4, 0),
                    KalahaPit(5, 0),
                    KalahaPit(6, 0),
                    KalahaPit(7, 6),
                    KalahaPit(8, 1),
                    KalahaPit(9, 0),
                    KalahaPit(10, 3),
                    KalahaPit(11, 0),
                    KalahaPit(12, 1),
                    KalahaPit(13, 0),
                    KalahaPit(14, 4),
            )
        }

        fun updatedBoard10(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 0),
                    KalahaPit(2, 0),
                    KalahaPit(3, 0),
                    KalahaPit(4, 0),
                    KalahaPit(5, 0),
                    KalahaPit(6, 0),
                    KalahaPit(7, 10),
                    KalahaPit(8, 1),
                    KalahaPit(9, 0),
                    KalahaPit(10, 0),
                    KalahaPit(11, 0),
                    KalahaPit(12, 1),
                    KalahaPit(13, 0),
                    KalahaPit(14, 4),
            )
        }

        fun updatedBoard11(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 1),
                    KalahaPit(2, 0),
                    KalahaPit(3, 3),
                    KalahaPit(4, 0),
                    KalahaPit(5, 1),
                    KalahaPit(6, 0),
                    KalahaPit(7, 6),
                    KalahaPit(8, 0),
                    KalahaPit(9, 0),
                    KalahaPit(10, 1),
                    KalahaPit(11, 0),
                    KalahaPit(12, 0),
                    KalahaPit(13, 0),
                    KalahaPit(14, 4),
            )
        }

        fun updatedBoard12(): List<KalahaPit> {
            return listOf(
                    KalahaPit(1, 1),
                    KalahaPit(2, 0),
                    KalahaPit(3, 0),
                    KalahaPit(4, 0),
                    KalahaPit(5, 1),
                    KalahaPit(6, 0),
                    KalahaPit(7, 6),
                    KalahaPit(8, 0),
                    KalahaPit(9, 0),
                    KalahaPit(10, 0),
                    KalahaPit(11, 0),
                    KalahaPit(12, 0),
                    KalahaPit(13, 0),
                    KalahaPit(14, 8),
            )
        }
    }
}