package com.example.jektloutre

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class ApiService {

    private val client = OkHttpClient()

    fun fetchData(url: String): String {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            return response.body?.string()?: ""
        }
    }
}
