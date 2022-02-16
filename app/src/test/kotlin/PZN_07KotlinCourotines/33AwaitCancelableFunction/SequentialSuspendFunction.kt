package PZN_07KotlinCourotines.`33AwaitCancelableFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class SequentialSuspendFunction {

    @Test
    fun testAwaitCancellation() {
        runBlocking {
            val job = launch {
                try {
                    println("Job Start")
                    awaitCancellation()
                } finally {
                    println("Cancelled")
                }
            }
            delay(5000)
            job.cancelAndJoin()
        }
    }
}
