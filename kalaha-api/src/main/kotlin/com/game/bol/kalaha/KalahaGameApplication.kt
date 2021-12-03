package com.game.bol.kalaha

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class KalahaGameApplication

fun main(args: Array<String>) {
	try {
		runApplication<KalahaGameApplication>(*args)
	} catch (e: Exception) {
		e.printStackTrace()
	}
}
