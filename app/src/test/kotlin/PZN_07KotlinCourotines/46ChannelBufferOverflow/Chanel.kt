package PZN_07KotlinCourotines.`46ChannelBufferOverflow`

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testChanelBufferOverflow() {
        runBlocking {
            val chanel = Channel<Int>(10, BufferOverflow.SUSPEND)
            val job1 = launch {
                repeat(100) {
                    println("Send data $it to channel")
                    chanel.send(it)
                }
            }
            job1.join()

            val job2 = launch {
                repeat(10) {
                    println("Received ${chanel.receive()}")
                }
            }
            job2.join()
        }
    }
}