package io.redspark.redstest.network

import android.content.Context
import java.io.IOException

object MockUtils {

    fun loadJSONFromAsset(context: Context?, fileName: String): String {
        val json: String
        try {
            val input = context?.assets?.open(fileName)
            val size = input?.available() ?: 0
            val buffer = ByteArray(size)
            input?.read(buffer)
            input?.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return String()
        }
        return json
    }

}