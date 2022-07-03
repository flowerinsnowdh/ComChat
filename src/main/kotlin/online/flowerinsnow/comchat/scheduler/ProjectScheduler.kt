package online.flowerinsnow.comchat.scheduler

import java.util.concurrent.ScheduledThreadPoolExecutor

/**
 * 本项目的任务管理器
 */
object ProjectScheduler {
    private var objInstance : ScheduledThreadPoolExecutor? = null

    val instance : ScheduledThreadPoolExecutor
        get() {
            return objInstance!!
        }

    @Throws(IllegalArgumentException::class)
    fun setInstance(instance : ScheduledThreadPoolExecutor) {
        if (objInstance != null) {
            throw IllegalStateException("Instance already set.")
        }
        objInstance = instance
    }
}