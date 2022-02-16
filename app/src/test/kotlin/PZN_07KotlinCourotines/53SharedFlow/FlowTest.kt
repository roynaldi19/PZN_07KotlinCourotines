package PZN_07KotlinCourotines.`53SharedFlow`

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
    fun testSharedFlow() {
        val scope = CoroutineScope(Dispatchers.IO)
        val sharedFlow = MutableSharedFlow<Int>()

        scope.launch {
           repeat(10){
               delay(1000)
               println("Send Job 1 $it : ${Date()}")
               sharedFlow.emit(it)
        }
    }
        scope.launch {
            sharedFlow.asSharedFlow()
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
