package PZN_07KotlinCourotines.`49BroadcastChanel`

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testBroadcastChanel() {
        val broadcastChannel = BroadcastChannel<Int>(10)

        val receiveChannel1 = broadcastChannel.openSubscription()
        val receiveChannel2 = broadcastChannel.openSubscription()

        val scope = CoroutineScope(Dispatchers.IO)
        val jobSend = scope.launch {
            repeat(10){
                broadcastChannel.send(it)
            }
        }
        val job1 = scope.launch {
            repeat(10){
                println("Job 1 ${receiveChannel1.receive()}")
            }
        }

        val job2 = scope.launch {
            repeat(10){
                println("Job 2 ${receiveChannel2.receive()}")
            }
        }

        runBlocking {
            joinAll(job1, job2, jobSend)
        }


}
}