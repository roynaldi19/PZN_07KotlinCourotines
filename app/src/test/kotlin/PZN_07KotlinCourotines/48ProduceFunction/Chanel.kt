package PZN_07KotlinCourotines.`48ProduceFunction`

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.junit.jupiter.api.Test

class Chanel {

    @Test
    fun testProduceChanel() {
        val scope = CoroutineScope(Dispatchers.IO)
        val chanel: ReceiveChannel<Int> = scope.produce {
            repeat(100) {
                send(it)
            }
        }

        val job = scope.launch {
            repeat(100){
                println(chanel.receive())
        }

    }
        runBlocking {
            job.join()
        }

}
}