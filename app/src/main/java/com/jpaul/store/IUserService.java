package com.jpaul.store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService{

    @POST("/user/login")
    Call<User> login(@Body User user);

    @GET("/user")
    Call<List<User>> fetch();


}
