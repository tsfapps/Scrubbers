package com.ecom.scrubbers.api;

import java.util.List;

import com.ecom.scrubbers.model.ModelCategory;
import com.ecom.scrubbers.model.user.ModelLogin;
import com.ecom.scrubbers.activity.ModelRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

//http://siguientesoftwares.in/gym_api/api_file/gym_register.php
    @FormUrlEncoded
    @POST("api_file/gym_register.php")
    Call<ModelRegister> createUser(

            @Field("email") String email,
            @Field("password") String password

    );







    @FormUrlEncoded
    @POST("com/ecom/scrubbers/api/login.php")
    Call<ModelLogin> createLogin(

            @Field("email") String email,
            @Field("password") String password

    );






    @POST("com/ecom/scrubbers/api/category.php")
    Call<List<ModelCategory>> getCat();






    @FormUrlEncoded
    @POST("/com/ecom/scrubbers/api/enquiry.php")
    Call<ModelCategory> userSubmit(

            @Field("req") String email,
            @Field("date") String date,
            @Field("time") String time

    );


}
