package PZN_07KotlinCourotines.`38Mutex`

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class LockingTest {

    @Test
    fun testRaceCondition() {
        var counter: Int = 0
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)

        repeat(100) {
            scope.launch {
                repeat(1000) {
                    counter++
                }
            }
        }
        runBlocking {
            delay(5)
            println("Total Counter : $counter")
        }
    }

    @Test
    fun testMutex() {
        var counter: Int = 0
        val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
        val scope = CoroutineScope(dispatcher)
        val mutex = Mutex()

        repeat(100) {
            scope.launch {
                repeat(1000) {
                    mutex.withLock {
                        counter++
                    }
                }
            }
        }
        runBlocking {
            delay(5)
            println("Total Counter : $counter")
        }
    }
}