package PZN_07KotlinCourotines.`06MenggunakanExcutorService`

import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

class testSingleThreadPool {

    @Test
    fun testSingleThreadPool(){
        val executorService = Executors.newSingleThreadExecutor()
        repeat(10){
            val runnable = Runnable {
                Thread.sleep(1_000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
            println("Selesai memasukan runnable $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }
}