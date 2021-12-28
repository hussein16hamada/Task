package com.example.task.logIn.api

import com.example.task.logIn.model.LogInModel
import io.reactivex.Single
import retrofit2.http.*

interface ApiCalls {
    @POST("login")
    @FormUrlEncoded
    fun logIn(
        @Field("MobileNumber") mobileNumber: Int,
        @Field("Password") password: Int
    ): Single<Any>

    @GET("GetPayroll ")
    fun getUserData(): Single<Any>


//    @GET("_english.json")
    //    Call <RecitersResponse> getAllRecitersEN();
    //    @GET("_arabic.json")
    //    Call <RecitersResponse> getAllRecitersAR();
    //    @GET("{reciters}")
    //    Single<Log> getAllRecitersAR(@Path("reciters") String re);
    //
    //
    //    @GET("radio/{radio}")
    //    Single<RadiosResponse> getAllRadioChannels(@Path("radio")String radio);
    //    @GET("radio/radio_en.json")
    //    Call<RadiosResponse> getAllRaioChannelsEN();
}