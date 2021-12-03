package com.game.bol.kalaha.models

import com.game.bol.kalaha.constants.KalahaEnum

data class KalahaPit(val pitIndex: Int, var stones: Int = KalahaEnum.PIT_STONES.value)
