package PZN_07KotlinCourotines.`02MembuatTread`

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class ThreadTest {

    @Test
    fun testNewThread(){
//        val runnable = Runnable {
//            println(Date())
//            Thread.sleep(2000)
//            println("Finish : ${Date()}")
//        }
//        val thread = Thread(runnable)
//        thread.start()

        thread (start = true){
            println(Date())
            Thread.sleep(2000)
            println("Finish : ${Date()}")
        }

        println("Menunggu Selesai 3 detik")
        Thread.sleep(3000)
        println("Selesai")
    }

}