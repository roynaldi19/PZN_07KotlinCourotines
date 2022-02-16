package PZN_07KotlinCourotines.`55SelectFunction`

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test
import java.util.*

class SelectTest {


    @Test
    fun testSelectDeferred() {
        val scope = CoroutineScope(Dispatchers.IO)

        val deferred1 = scope.async {
            delay(1000)
            1000
        }

        val deferred2 = scope.async {
            delay(2000)
            2000
        }

        val job = scope.launch {
            val win = select<Int> {
                deferred1.onAwait{ it }
                deferred2.onAwait{ it }
            }
            println("Win : $win")
        }

        runBlocking {
            job.join()
        }

}

}
