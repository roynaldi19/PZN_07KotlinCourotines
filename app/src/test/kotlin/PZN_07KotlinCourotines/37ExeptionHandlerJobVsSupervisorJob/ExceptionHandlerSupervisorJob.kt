package PZN_07KotlinCourotines.`37ExeptionHandlerJobVsSupervisorJob`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class ExceptionHandlerSupervisorJob {

    @Test
    fun testJobExceptionHandler() {

        val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
            println("Error ${throwable.message}")
        }

        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        runBlocking {
            val job = scope.launch {
                launch(exceptionHandler) {
                    println("Job Child")
                    throw IllegalArgumentException("Child Error")
                }
            }
            job.join()
        }
    }

    @Test
    fun testSupervisorJobExceptionHandler() {

        val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
            println("Error ${throwable.message}")
        }

        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        runBlocking {
            val job = scope.launch {
                supervisorScope {
                    launch(exceptionHandler) {
                        println("Job Child")
                        throw IllegalArgumentException("Child Error")
                    }
                }
            }
            job.join()
        }
    }
}