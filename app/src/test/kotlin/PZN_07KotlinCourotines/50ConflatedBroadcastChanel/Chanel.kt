package PZN_07KotlinCourotines.`50ConflatedBroadcastChanel`

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testConflatedBroadcastChanel() {
        val conflatedBroadcastChannel = ConflatedBroadcastChannel<Int>()

        val receiveChannel = conflatedBroadcastChannel.openSubscription()

        val scope = CoroutineScope(Dispatchers.IO)
        val job1 = scope.launch {
            repeat(10){
                delay(1000)
                println("Send $it")
                conflatedBroadcastChannel.send(it)
            }
        }

        val job2 = scope.launch {
            repeat(10){
                delay(2000)
               println("Receive ${receiveChannel.receive()}")
            }
        }

        runBlocking {
            delay(11000)
            scope.cancel()
        }


}
}