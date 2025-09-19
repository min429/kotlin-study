package coroutine

import kotlinx.coroutines.*

object runBlocking {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main() // runBlocking으로 인해 대기한다.
        println("=========================end=========================")
    }

    fun main() = runBlocking { // 호출한 스레드에서 그대로 코루틴을 수행한다.
        // 자식 코루틴
        launch {
            delay(1000L)
            println("launch() is running on ${Thread.currentThread().name}") // main
        }

        // 코루틴
        println("runBlocking is running on ${Thread.currentThread().name}") // main
    }
}
