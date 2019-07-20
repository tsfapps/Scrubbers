package com.ecom.scrubbers.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("api/register.php")
    Call<ModelRegister> createUser(

            @Field("email") String email,
            @Field("password") String password

    );







    @FormUrlEncoded
    @POST("api/login.php")
    Call<ModelLogin> createLogin(

            @Field("email") String email,
            @Field("password") String password

    );






    @POST("api/category.php")
    Call<List<ModelCategory>> getCat();






    @FormUrlEncoded
    @POST("/api/enquiry.php")
    Call<ModelCategory> userSubmit(

            @Field("req") String email,
            @Field("date") String date,
            @Field("time") String time

    );


}
