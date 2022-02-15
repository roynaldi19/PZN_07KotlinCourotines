package PZN_07KotlinCourotines.`20CoroutineContext`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.coroutines.CoroutineContext

class CoroutineContext {

    @Test
    fun testCoroutineContext(){
        runBlocking {
            val job = GlobalScope.launch {
                val context: CoroutineContext = coroutineContext
                println(context)
            }
            job.join()
        }
    }

}