package coroutine

import kotlinx.coroutines.*
import kotlin.properties.*

object async {

    @JvmStatic
    fun main(args: Array<String>) {
        println("========================start========================")
        this.main()
        println("=========================end=========================")
    }

    var a: Int by Delegates.notNull() // 초기화 전 접근 시 예외 발생

    fun main() = runBlocking {
        val d = getDeferredObject() // Deferred 객체
        println(a) // 예외 발생
    }

    fun getDeferredObject() = CoroutineScope(Dispatchers.Default).async {
        delay(1000L)
        a = 1
    }
}