package elevator

import mu.KotlinLogging

fun main() {
    val creatingOfObjectDoesNotRequireNewKeyword = KotlinIsSimple("")
    log.info { "App started" }
}

private val log = KotlinLogging.logger {}