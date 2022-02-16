package PZN_07KotlinCourotines.`25CoroutineScope`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    @Test
    fun testScope() {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            delay(1000)
            println("Run ${Thread.currentThread().name}")
        }

        scope.launch {
            delay(1000)
            println("Run ${Thread.currentThread().name}")
        }

        runBlocking {
            delay(2000)
            println("Done")
        }
    }
}