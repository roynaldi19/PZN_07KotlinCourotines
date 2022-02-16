package PZN_07KotlinCourotines.`40AsynchonusFlow`

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowTest {

    @Test
    fun testFlow() {
        val flow1: Flow<Int> = flow {
            println("Start flow")
            repeat(100) {
                println("Emit $it")
                emit(it)
            }
        }

        runBlocking {
            flow1.collect {
                println("Receive $it")
            }
        }

    }
}
