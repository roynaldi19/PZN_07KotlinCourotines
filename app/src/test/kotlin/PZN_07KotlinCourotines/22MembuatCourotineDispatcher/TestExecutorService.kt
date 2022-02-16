package PZN_07KotlinCourotines.`22MembuatCourotineDispatcher`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class TestExecutorService {

    @Test
    fun testExecutorService() {
        val dispatcherService = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val dispatcherWeb = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

        runBlocking {
            val job1 = GlobalScope.launch(dispatcherService) {
                println("Job1 : ${Thread.currentThread().name}")
            }
            val job2 = GlobalScope.launch(dispatcherWeb) {
                println("Job2 : ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }
}