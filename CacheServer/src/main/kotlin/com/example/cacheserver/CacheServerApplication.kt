package com.example.cacheserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CacheServerApplication

fun main(args: Array<String>) {
	runApplication<CacheServerApplication>(*args)
}
