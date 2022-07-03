package online.flowerinsnow.comchat

import online.flowerinsnow.comchat.gui.LoginGui
import online.flowerinsnow.comchat.scheduler.ProjectScheduler
import java.util.concurrent.ScheduledThreadPoolExecutor

object Main {
    @JvmStatic
    fun main(args : Array<String>) {
        ProjectScheduler.setInstance(ScheduledThreadPoolExecutor(32)) // 初始化项目任务管理器

        LoginGui().init() // 临时测试用
    }
}