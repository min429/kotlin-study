package coroutine

import kotlinx.coroutines.*

object suspend {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking { // this: CoroutineScope
        launch { doWorld() }
        println("Hello")
    }

    // 코루틴 블록에 넣기 위해서는 suspend 함수여야 한다.
    suspend fun doWorld() {
        delay(1000L)
        println("World!")
    }
}
