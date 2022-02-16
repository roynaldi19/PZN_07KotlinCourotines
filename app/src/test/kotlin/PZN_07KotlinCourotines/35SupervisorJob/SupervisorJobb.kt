package PZN_07KotlinCourotines.`35SupervisorJob`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SupervisorJobb {

    @Test
    fun testJob() {
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher + Job())

        val job1 = scope.launch {
            delay(2000)
            println("Job 1 done")
        }
        val job2 = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Job 2 Failed")
        }

        runBlocking {
            joinAll(job1, job2)
        }
    }

    @Test
    fun testSupervisorJob() {
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher + SupervisorJob())

        val job1 = scope.launch {
            delay(2000)
            println("Job 1 done")
        }
        val job2 = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Job 2 Failed")
        }

        runBlocking {
            joinAll(job1, job2)
        }
    }
}