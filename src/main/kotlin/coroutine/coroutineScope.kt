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
        withCoroutineScope() // 완료 보장
        withLaunch() // 완료 보장x
    }

    // launch는 하위 suspending 함수가 모두 종료됨을 보장하지 않는다.
    fun withLaunch() = CoroutineScope(Dispatchers.Default).launch {
        helloWorld()
    }

    suspend fun helloWorld() {
        delay(1000L)
        println("Hello World!")
    }

    // coroutineScope는 하위 suspending 함수가 모두 종료됨을 보장한다.
    suspend fun withCoroutineScope() = coroutineScope {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
    }
}
