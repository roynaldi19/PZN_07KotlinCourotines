package PZN_07KotlinCourotines.`23WhitContextFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class TestExecutorService {

    @Test
    fun testWhitContext() {
        val dispatcherClient = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        runBlocking {
            val job = GlobalScope.launch(Dispatchers.IO) {
                println("1 : ${Thread.currentThread().name}")
                withContext(dispatcherClient){
                    println("2 : ${Thread.currentThread().name}")
                }
                println("3 : ${Thread.currentThread().name}")
            }
            job.join()
        }
    }
}