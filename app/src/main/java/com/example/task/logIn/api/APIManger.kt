package com.example.task.logIn.api

import com.example.task.base.MyApplication
import com.example.task.base.TinyDB
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

object APIManger {
    private var retrofitInstance: Retrofit? = null
    private lateinit var tinyDB: TinyDB
    private fun getInstance(): Retrofit? {
        if (retrofitInstance == null) {
             tinyDB= TinyDB(MyApplication.getAppContext())
             val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

             val client = OkHttpClient.Builder()

                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + tinyDB.getString("token"))
                            .build()
                        return chain.proceed(request)
                    }
                })
                .addInterceptor(interceptor)
                .build()


            retrofitInstance = Retrofit.Builder()
                .baseUrl("http://40.127.194.127:5656/Salamtak/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofitInstance
    }

    public fun getApis() :ApiCalls?{
        val apiCalls = getInstance()?.create(ApiCalls::class.java)
         return apiCalls
    }
//    val apis: ApiCalls
//        get() = getInstance(token = null)!!.create(ApiCalls::class.java)
}