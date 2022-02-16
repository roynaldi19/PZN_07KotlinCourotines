package PZN_07KotlinCourotines.`36SupervisorScopeFunction`

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SupervisorJobb {

    @Test
    fun testSupervisorScopeFunction() {
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher + Job())

        runBlocking {
            scope.launch {
                supervisorScope {
                    launch {
                        delay(2000)
                        println("Child 1 done")
                    }
                    launch {
                        delay(1000)
                        throw IllegalArgumentException("Child 2 Failed")
                    }
                }
            }
            delay(3000)
        }
    }
}