package PZN_07KotlinCourotines

import org.junit.jupiter.api.Test

class MainTest {

    @Test
    fun testThreadName() {
        val threadName = Thread.currentThread().name
        println("Running in $threadName")
    }
}