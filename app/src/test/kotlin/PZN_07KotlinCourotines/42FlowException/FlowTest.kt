package PZN_07KotlinCourotines.`42FlowException`

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    @Test
    fun testFlowException() {
        runBlocking {
            numberFlow()
                .map { check(it < 10); it }
                .onEach { println(it) }
                .catch { println("Error ${it.message}") }
                .onCompletion { println("Done") }
                .collect()
        }
    }

}
