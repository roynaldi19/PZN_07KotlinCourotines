package PZN_07KotlinCourotines.`29CancelableChildrenFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    @Test
    fun testParentChildCancel() {
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
            job.cancelChildren()
            job.join()
        }
    }

}