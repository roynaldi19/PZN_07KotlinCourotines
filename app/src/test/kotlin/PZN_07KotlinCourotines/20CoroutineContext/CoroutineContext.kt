package PZN_07KotlinCourotines.`20CoroutineContext`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

class CoroutineContext {

    @ExperimentalStdlibApi
    @Test
    fun testCoroutineContext(){
        runBlocking {
            val job = GlobalScope.launch {
                val context: CoroutineContext = coroutineContext
                println(context)
                println(context[Job])
                println(context[CoroutineDispatcher])
            }
            job.join()
        }
    }

}