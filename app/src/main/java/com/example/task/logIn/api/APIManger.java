package com.example.task.logIn.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManger {

    private static Retrofit retrofitInstance;



  private static Retrofit getInstance(){



      if (retrofitInstance==null){
           retrofitInstance = new Retrofit.Builder()
                   .baseUrl("http://40.127.194.127:5656/Salamtak/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();
       }
       return retrofitInstance;
   }

   public static ApiCalls getApis(){
      ApiCalls apiCalls=getInstance().create(ApiCalls.class);
        return apiCalls;
   }
}
