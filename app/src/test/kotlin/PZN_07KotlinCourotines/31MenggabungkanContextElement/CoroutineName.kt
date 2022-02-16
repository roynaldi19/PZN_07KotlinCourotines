package PZN_07KotlinCourotines.`31MenggabungkanContextElement`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class CoroutineName {

    @Test
    fun testCoroutineElement() {
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(Dispatchers.IO + CoroutineName("test"))
        val job = scope.launch(CoroutineName("parent") + dispatcher) {
            println("Parent run in thread : ${Thread.currentThread().name}")
            withContext(CoroutineName("child") + Dispatchers.IO) {
                println("Child run in Thread : ${Thread.currentThread().name}")
            }
        }
        runBlocking {
            job.join()
        }
    }
}