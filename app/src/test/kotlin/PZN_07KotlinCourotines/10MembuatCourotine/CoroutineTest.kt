package PZN_07KotlinCourotines.`10MembuatCourotine`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineTest {
    suspend fun hello(){
        delay(1000)
        println("Hello World")
    }

    @Test
    fun testCoroutine(){
        GlobalScope.launch {
            hello()
        }

        println("Menunggu")
        runBlocking {
            delay(2000)
        }
        println("Selesai")
    }
}