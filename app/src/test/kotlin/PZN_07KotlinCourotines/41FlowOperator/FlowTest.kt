package PZN_07KotlinCourotines.`41FlowOperator`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    suspend fun changeToString(number: Int): String {
        delay(100)
        return "Number $number"
    }

    @Test
    fun testFlowOperator() {
        runBlocking {
            val flow1 = numberFlow()
            flow1.filter { it % 2 == 0 }
                .map { changeToString(it) }
                .collect { println(it) }
        }
    }

}
