package PZN_07KotlinCourotines.`19AwaitAllFunctioon`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AsyncTest {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @Test
    fun testAwaitAll() {
        runBlocking {
            val time = measureTimeMillis {
                val foo1: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar1: Deferred<Int> = GlobalScope.async { getBar() }
                val foo2: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar2: Deferred<Int> = GlobalScope.async { getBar() }

                val result = awaitAll(foo1, bar1, foo2, bar2).sum()
                println("Result : $result")
            }
            println("Total time: $time")
        }
    }
}