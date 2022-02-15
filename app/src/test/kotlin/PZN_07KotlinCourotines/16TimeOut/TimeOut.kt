package PZN_07KotlinCourotines.`16TimeOut`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class TimeOut {

    @Test
    fun testTimeOut() {
        runBlocking {
            val job = GlobalScope.launch {
                println("Start Coroutine")
                withTimeout(5000){
                    repeat(10){
                        delay(1000)
                        println("$it ${Date()}")
                    }
                }
                println("Finish Coroutine")
            }
            job.join()
        }
    }

    @Test
    fun testTimeOutOrNull() {
        runBlocking {
            val job = GlobalScope.launch {
                println("Start Coroutine")
                withTimeoutOrNull(5000){
                    repeat(10){
                        delay(1000)
                        println("$it ${Date()}")
                    }
                }
                println("Finish Coroutine")
            }
            job.join()
        }
    }
}