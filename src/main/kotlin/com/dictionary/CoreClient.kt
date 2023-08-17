package com.urbandictionary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class CoreClient(baseUrl: String) {
    private var httpClient: OkHttpClient = OkHttpClient.Builder().build()

    // custom [Retrofit] client to add custom [OkHttpClient] and add Gson (JSON) support
    protected val retroClient: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(httpClient)
        .build()
}