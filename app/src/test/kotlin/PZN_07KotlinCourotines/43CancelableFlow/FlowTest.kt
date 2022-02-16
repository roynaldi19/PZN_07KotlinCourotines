package PZN_07KotlinCourotines.`43CancelableFlow`

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Test

class FlowTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    @Test
    fun testCancellableFlow() {
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            scope.launch {
                numberFlow()
                    .onEach {
                        if (it > 10) cancel()
                        else println(it)
                    }
            }
        }
    }

}
