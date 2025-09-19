package coroutine

import kotlinx.coroutines.*

object withContext {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking {
        runWithContext() // 동기 호출 -> withContext 출력o
        runLaunch() // 비동기 호출 -> launch 출력x
    }

    // 새로운 코루틴을 만들어서 병렬로 실행한다.
    fun runLaunch() = CoroutineScope(Dispatchers.Default).launch {
        delay(1000L)
        println("launch")
    }

    // 현재 코루틴에서 이 블록은 별도의 컨텍스트에서 실행한다.
    suspend fun runWithContext() = withContext(Dispatchers.Default) {
        delay(1000L)
        println("withContext")
    }
}