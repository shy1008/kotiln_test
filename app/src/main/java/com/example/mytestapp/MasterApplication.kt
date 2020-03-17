package com.example.mytestapp

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient

class MasterApplication : Application(){
    override fun onCreate() {
        super.onCreate()


        //레트로핏?
        createRetrofit()
    }

    fun createRetrofit(){
        val header = Interceptor {
            val original = it.request()
            val requeset = original.newBuilder()
                .header("Authorizationb","")
                .build()
            it.proceed(requeset)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
//        val retrofit = Ret

    }
}