package PZN_07KotlinCourotines.`24NonCancelableCourotine`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class TestExecutorService {

    @Test
    fun testNonCancelable() {
        runBlocking {
            val job = GlobalScope.launch {
                try {
                    println("Start Job")
                    delay(1000)
                    println("End Job")
                } finally {
                    withContext(NonCancellable){
                        delay(1000)
                        println("Finally")
                    }
                }
            }
            job.cancelAndJoin()
        }
    }
}