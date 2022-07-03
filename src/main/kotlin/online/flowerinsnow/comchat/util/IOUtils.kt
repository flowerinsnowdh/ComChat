package online.flowerinsnow.comchat.util

object IOUtils {
    /**
     * 静默关闭可关闭的对象
     * 只管关闭，无视一切异常
     *
     * @param acs 可关闭的对象
     */
    @JvmStatic
    fun closeQuietly(vararg acs : AutoCloseable?) {
        acs.forEach {
            if (it != null) {
                try {
                    it.close()
                } catch (_ : Exception) {
                }
            }
        }
    }
}