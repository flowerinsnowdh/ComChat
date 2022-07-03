package online.flowerinsnow.comchat.util

import java.awt.Toolkit

object DimensionUtils {
    /**
     * 整个屏幕大小
     */
    val screenSize = Toolkit.getDefaultToolkit().screenSize

    /**
     * 整个屏幕的宽
     */
    val screenWidth = screenSize.width

    /**
     * 整个屏幕的高
     */
    val screenHeight = screenSize.height

    /**
     * 获取整个屏幕的`multiply`倍宽
     *
     * @param multiply 乘数
     * @return 结果大小
     */
    fun widthOfScreen(multiply : Float) : Int {
        return sizeOf(screenWidth, multiply)
    }

    /**
     * 获取整个屏幕的`multiply`倍高
     *
     * @param multiply 乘数
     * @return 结果大小
     */
    fun heightOfScreen(multiply : Float) : Int {
        return sizeOf(screenHeight, multiply)
    }

    /**
     * 获取`size`的`multiply`倍
     *
     * @param size 总大小，int类型
     * @param multiply 乘数，float类型
     * @return 最后的积，转换后的int类型
     */
    fun sizeOf(size : Int, multiply : Float) : Int {
        return (size.toFloat() * multiply).toInt()
    }
}