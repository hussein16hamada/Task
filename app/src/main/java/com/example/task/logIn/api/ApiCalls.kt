package com.example.task.logIn.api

import com.example.task.logIn.model.LogInResponse
import com.example.task.logIn.model.UserResponse
import io.reactivex.Single
import retrofit2.http.*

interface ApiCalls {
    @POST("login")
    @FormUrlEncoded
    fun logIn(
        @Field("MobileNumber") mobileNumber: String,
        @Field("Password") password: Int
    ): Single<LogInResponse>

    @GET("GetPayroll ")
    fun getUserData(): Single<UserResponse>


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