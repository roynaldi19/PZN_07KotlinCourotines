package PZN_07KotlinCourotines.`32YieldFuction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

class SequentialSuspendFunction {

    suspend fun runJob(number: Int){
        println("Start Job $number in thread ${Thread.currentThread().name}")
        yield()
        println("End Job $number in thread ${Thread.currentThread().name}")
    }

    @Test
    fun testYieldFunction(){
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        runBlocking{
            scope.launch { runJob(1) }
            scope.launch { runJob(2) }
            delay(2000)
        }
    }
}
