package coroutine

import kotlinx.coroutines.*

object propagation {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking {
        parent().join()
    }

    fun parent() = CoroutineScope(Dispatchers.Default).launch {
        println("parent")

        // parent는 child가 끝날 때까지 대기한다.
        child()
    }

    // CoroutineScope의 확장함수 정의
    fun CoroutineScope.child() = launch { // 부모 스코프를 그대로 사용
        delay(1000L)
        println("child")
        throw CancellationException("Cancelled") // CancellationException이 발생해도 부모 스코프는 취소되지 않는다.
    }
}

object nonPropagation {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    fun main() = runBlocking {
        scope1().join()
    }

    fun scope1() = CoroutineScope(Dispatchers.Default).launch {
        println("scope1")

        // scope1은 scope2가 끝날 때까지 대기하지 않는다.
        scope2()
    }

    // CoroutineScope의 확장함수 정의
    fun scope2() = CoroutineScope(Dispatchers.Default).launch { // 독립적인 스코프
        delay(1000L)
        println("scope2")
        throw CancellationException("Cancelled")
    }
}