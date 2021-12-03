package com.game.bol.kalaha.exceptions

data class KalahaGameExceptionResponseModel(val timeStamp:String, val exceptionType:String, val message:String)

data class KalahaApiException (override val message:String) : RuntimeException(message)