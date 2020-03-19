package com.example.mytestapp

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{

    @GET("json/students/")
    fun getStudentList() : Call<ArrayList<PersonFromServer>>
}