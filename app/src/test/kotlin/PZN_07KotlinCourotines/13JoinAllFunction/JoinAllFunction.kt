package PZN_07KotlinCourotines.`13JoinAllFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class JoinAllFunction {

    @Test
    fun testJobJoinAll(){
        runBlocking {
            val job1: Job = GlobalScope.launch() {
                delay(2000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }
            val job2: Job = GlobalScope.launch() {
                delay(2000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }
}