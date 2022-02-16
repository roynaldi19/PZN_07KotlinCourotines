package PZN_07KotlinCourotines.`21CoroutineDispatcher`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineDispatcher {

    @Test
    fun testDispatcher() {
        runBlocking {
            println("runBlocking ${Thread.currentThread().name}")
            val job1 = GlobalScope.launch(Dispatchers.Default) {
                println("Job1 ${Thread.currentThread().name}")
            }
            val job2 = GlobalScope.launch(Dispatchers.Default) {
                println("Job2 ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }
}