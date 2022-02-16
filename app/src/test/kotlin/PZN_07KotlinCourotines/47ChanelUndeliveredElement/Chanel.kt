package PZN_07KotlinCourotines.`47ChanelUndeliveredElement`

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testChanelUndelivered() {
        val chanel = Channel<Int>(10) { value ->
            println("undelivered Element $value")
        }
        chanel.close()
        runBlocking {
            val job = launch {
                chanel.send(10)
                chanel.send(100)
            }
            job.join()
        }

    }
}