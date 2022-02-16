package PZN_07KotlinCourotines.`54StateFlow`

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.jupiter.api.Test
import java.util.*

class FlowTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    @Test
    fun testStateFlow() {
        val scope = CoroutineScope(Dispatchers.IO)
        val stateFlow = MutableStateFlow(0)

        scope.launch {
           repeat(10){
               delay(1000)
               println("Send Job 1 $it : ${Date()}")
               stateFlow.emit(it)
        }
    }
        scope.launch {
            stateFlow.asStateFlow()
                .map { "Receive Job 1 : $it : ${Date()}" }
                .collect{
                    delay(2000)
                    println(it)
                }
        }
        runBlocking {
            delay(22000)
            scope.cancel()
        }
}

}
