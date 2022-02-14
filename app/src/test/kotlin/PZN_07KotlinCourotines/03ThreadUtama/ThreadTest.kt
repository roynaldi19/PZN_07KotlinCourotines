package PZN_07KotlinCourotines.`03ThreadUtama`

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class ThreadTest {

    @Test
    fun testThreadName(){
        val threadName = Thread.currentThread().name
        println("Running in thread $threadName")
    }
}