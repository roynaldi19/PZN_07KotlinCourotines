package PZN_07KotlinCourotines.`45ChanelBackpressure`

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testChanelUnlimited() {
        runBlocking {
            val chanel = Channel<Int>(Channel.UNLIMITED)
            val job1 = launch {
                println("Send data 1 to channel")
                chanel.send(1)
                println("Send data 2 to channel")
                chanel.send(2)
            }
            val job2 = launch {
                println("Received ${chanel.receive()}")
                println("Received ${chanel.receive()}")
            }
            joinAll(job1, job2)
            chanel.close()
        }
    }
}