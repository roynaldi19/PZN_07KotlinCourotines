package PZN_07KotlinCourotines.`30MemberiNamaCoroutine`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineName {

    @Test
    fun testName() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch(CoroutineName("parent")) {
            println("Run in thread : ${Thread.currentThread().name}")
            withContext(CoroutineName("child")) {
                println("Run in Thread : ${Thread.currentThread().name}")
            }
        }
        runBlocking {
            job.join()
        }
    }
}