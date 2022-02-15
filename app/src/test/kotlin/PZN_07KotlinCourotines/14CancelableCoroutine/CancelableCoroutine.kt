package PZN_07KotlinCourotines.`14CancelableCoroutine`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class CancelableCoroutine {

    @Test
    fun testNotCancel(){
        runBlocking {
            val job = GlobalScope.launch {
                println("Start Coroutine ${Date()}")
                Thread.sleep(2000)
                println("End Coroutine ${Date()}")
            }
            job.cancel()
            delay(3000)
        }
    }

    @Test
    fun testCancelable(){
        runBlocking {
            val job = GlobalScope.launch {
                if (!isActive) throw CancellationException()
                println("Start Coroutine ${Date()}")
                ensureActive()
                Thread.sleep(2000)
                ensureActive()
                println("End Coroutine ${Date()}")
            }
            job.cancel()
            delay(3000)
        }
    }


}