package elevator

import mu.KotlinLogging
import kotlin.random.Random

// This is a primary constructor
class KotlinIsSimple(
    private val thisIsAPrivateField: String,
    val publicFieldWithDefaultValue: String = "default",
    constructorArgumentWithoutCorrespondingField: String? = null
) {
    private val valueCannotBeChanged = 1
    private var variableCanBeChanged: Int? = null
    private var notNullVariableCanBeChanged: Int = 1

    init {
        log.info { "This is an initialization section" }

        Thread {
            log.debug { "Starting threads is simple too" }
        }.start()
        Thread({
            log.debug { "Don't be confused by braces - it's just a sugar for case when last arguments is a function/lambda" }
        }, "Thread name").start()
    }

    fun publicMethod(arg: String): String {
        return "public: $arg"
    }

    private fun privateMethod(arg: Collection<String>): String {
        val collectionsAreImmutableByDefault = arg
        val butYouCanCreateAMutableCollection: MutableCollection<String> = arg.toMutableList()

        butYouCanCreateAMutableCollection
            .map { str -> str.uppercase() } // lambda doesn't require "return"
            .map { it.lowercase() }
            .filter { it.contains("abc") }
            .forEach { _ -> println("Streams and lambdas is very close to Java") }

        while (Random.nextBoolean()) {
            println("Loops are the same")
        }
        for (i in 0..100) {
            println("Except for 'for' loops")
        }
        for (i in 0 until 100) {
            println("Except for 'for' loops")
        }
        for (value in arg) {
            println()
        }

        val ifCanReturnAValue = if (Random.nextBoolean()) {
            "Last variable or value of if can be returned"
        } else {
            var itIsNotTheLastValue = "str"
            itIsNotTheLastValue += "2"
            itIsNotTheLastValue
        }

        val useWhenInsteadOfSwitch = when (collectionsAreImmutableByDefault.size) {
            1 -> "size is 1"
            2 -> "size is 2"
            else -> "unknown size"
        }

        return ifCanReturnAValue
    }

    companion object {
        // Use companion object instead of Java static fields/methods
        private val log = KotlinLogging.logger {}
    }
}

data class DataClassesHasEqualsAndHashCodeByDefault(
    val propA: String,
    val propB: String
)