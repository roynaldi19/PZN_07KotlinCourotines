package PZN_07KotlinCourotines.`15SetelahCoroutineCancel`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class CancelableCoroutine {
    @Test
    fun testCancelFinally() {
        runBlocking {
            val job = GlobalScope.launch {
                try {
                    println("Start Coroutine ${Date()}")
                    delay(2000)
                    println("End Coroutine ${Date()}")
                } finally {
                    println("Finally")
                }
            }
            job.cancelAndJoin()
        }
    }
}