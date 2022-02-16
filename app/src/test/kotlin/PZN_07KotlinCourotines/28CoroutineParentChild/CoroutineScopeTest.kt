package PZN_07KotlinCourotines.`28CoroutineParentChild`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    @Test
    fun testParentChild() {
        runBlocking {
            val job = GlobalScope.launch {
                launch {
                    delay(2000)
                    println("Child 1 finish")
                }
                launch {
                    delay(4000)
                    println("Child 2 finish")
                }
                delay(1000)
                println("Parent Finish")
            }
            job.join()
        }
    }

}