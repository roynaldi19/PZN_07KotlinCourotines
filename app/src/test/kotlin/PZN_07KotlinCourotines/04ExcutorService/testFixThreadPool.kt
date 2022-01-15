package PZN_07KotlinCourotines.`04ExcutorService`

import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

class testFixThreadPool {

    @Test
    fun testFixThreadPool(){
        val executorService = Executors.newFixedThreadPool(4)
        repeat(10){
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
            println("Selasai memasukan runnable $it")
        }
        println("Menunggu")
        Thread.sleep(11000)
        println("Selesai")
    }
}