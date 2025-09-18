package coroutine

import kotlinx.coroutines.*

object coroutineScope {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking {
        doWorld()
    }

    suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
    }
}
