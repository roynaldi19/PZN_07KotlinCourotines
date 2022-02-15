package PZN_07KotlinCourotines.`11CourotineSangatRingan`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class CoroutineTest {

    @Test
    fun testThread(){
        repeat(10000){
            thread {
                Thread.sleep(1000)
                println("Done $it : ${Date()} ${Thread.currentThread().name}")
            }
        }

        println("Menunggu")
        Thread.sleep(2000)
        println("Selesai")
    }

    @Test
    fun testCoroutine(){
        repeat(10000){
            GlobalScope.launch {
                delay(1000)
                println("Done $it : ${Date()} ${Thread.currentThread().name}")
            }
        }

        println("Menunggu")
        runBlocking {
            delay(3000)
        }
        println("Selesai")

    }
    
}