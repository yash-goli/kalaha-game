package com.game.bol.kalaha.constants

enum class KalahaPlayerEnum {
    PLAYER_A_START_INDEX {
        override fun calculateIndex(): Int = 1
    },
    PLAYER_A_END_INDEX {
        override fun calculateIndex(): Int = KalahaEnum.PITS.value
    },
    PLAYER_A_PIT_HEAD_INDEX {
        override fun calculateIndex(): Int = KalahaEnum.PITS.value + 1
    },
    PLAYER_B_START_INDEX {
        override fun calculateIndex(): Int = KalahaEnum.PITS.value + 2
    },
    PLAYER_B_END_INDEX {
        override fun calculateIndex(): Int = (KalahaEnum.PITS.value * 2) + 1
    },
    PLAYER_B_PIT_HEAD_INDEX {
        override fun calculateIndex(): Int = (KalahaEnum.PITS.value * 2) + 2
    },
    TOTAL_PITS {
        override fun calculateIndex(): Int = (KalahaEnum.PITS.value * 2) + 2
    };

    abstract fun calculateIndex(): Int
}