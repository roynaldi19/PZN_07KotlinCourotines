package PZN_07KotlinCourotines.`05MultipleThread`

import org.junit.jupiter.api.Test
import java.util.*

class ThreadTest {

    @Test
    fun testMultipleThread(){
        val thread1 = Thread {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 1 ${Thread.currentThread().name} : ${Date()}")
        }

        val thread2 = Thread {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 2 ${Thread.currentThread().name} : ${Date()}")
        }

        val thread3 = Thread {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 3 ${Thread.currentThread().name} : ${Date()}")
        }

        val thread4 = Thread {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 4 ${Thread.currentThread().name} : ${Date()}")
        }

        thread1.start()
        thread2.start()
        thread3.start()
        thread4.start()

        println("Menunggu Selesai 3 detik")
        Thread.sleep(3000)
        println("Selesai")
    }
}