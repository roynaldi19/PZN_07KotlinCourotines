package PZN_07KotlinCourotines.`34ExceptionHandling`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ExceptionHandlingTest {

    @Test
    fun testExceptionLaunch(){
        runBlocking {
            val job = GlobalScope.launch {
                println("Start coroutine")
                throw IllegalArgumentException()
            }
            job.join()
            println("Finish")
        }
    }

    @Test
    fun testExceptionAsync(){
        runBlocking {
            val deferred = GlobalScope.async {
                println("Start coroutine")
                throw IllegalArgumentException()
            }
            try {
                deferred.await()
            } catch (error: IllegalArgumentException){
                println("Error")
            } finally {
                println("Finish")
            }
        }
    }
}