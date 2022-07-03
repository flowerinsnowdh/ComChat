package online.flowerinsnow.comchat.util

object UnicodeUtils {
    fun isNumber(ch : Char) : Boolean {
        return ch.code in 48..57
    }
}