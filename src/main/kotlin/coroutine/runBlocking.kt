package coroutine

import kotlinx.coroutines.*

object runBlocking {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking { // this: CoroutineScope
        // 코루틴 블록
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }

        // 코루틴 x
        println("Hello") // main coroutine continues while a previous one is delayed
    }
}
