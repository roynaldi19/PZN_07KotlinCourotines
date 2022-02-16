package PZN_07KotlinCourotines.`27CoroutineScopeParentChild`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class CoroutineScopeTest {

    @Test
    fun testParentChildDispatcher() {
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        val job = scope.launch {
            println("Parent Scope : ${Thread.currentThread().name}")
            coroutineScope {
                launch {
                    println("Child scope : ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.join()
        }
    }
}