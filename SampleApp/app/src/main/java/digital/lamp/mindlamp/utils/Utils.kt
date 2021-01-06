package digital.lamp.mindlamp.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import java.io.UnsupportedEncodingException
import java.util.*


object Utils {
    @SuppressLint("NewApi")
    fun toBase64(message: String): String? {
        val data: ByteArray
        try {
            data = message.toByteArray(charset("UTF-8"))
            return Base64.getMimeEncoder().encodeToString(data)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return null
    }

    fun getApplicationName(context: Context): String {
        return context.applicationInfo.loadLabel(context.packageManager).toString()
    }

    @Suppress("DEPRECATION")
    fun <T> Context.isServiceRunning(service: Class<T>): Boolean {
        return (getSystemService(ACTIVITY_SERVICE) as ActivityManager)
            .getRunningServices(Integer.MAX_VALUE)
            .any { it -> it.service.className == service.name }
    }
}