package PZN_07KotlinCourotines.`26CoroutineScopeFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    suspend fun getSum(): Int = coroutineScope {
        val foo = async { getFoo() }
        val bar = async { getBar() }
        foo.await() + bar.await()
    }

    @Test
    fun testCoroutineScopeFunction() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            val result = getSum()
            println("Result $result")
        }
        runBlocking {
            job.join()
        }
    }
}