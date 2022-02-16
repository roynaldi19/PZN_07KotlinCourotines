package PZN_07KotlinCourotines.`52TickerFunction`

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*

class TickerTest {

    @Test
    fun testTicker() {
        val receivedChanel = ticker(1000)
        runBlocking {
            val job = launch {
                repeat(10) {
                    receivedChanel.receive()
                    println(Date())
                }
            }
            job.join()
        }
    }
}