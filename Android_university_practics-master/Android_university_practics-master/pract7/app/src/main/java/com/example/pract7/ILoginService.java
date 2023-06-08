package com.example.pract7;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginService {

    @POST("/api/login")
    Call<LoginResponse> login(@Body LoginBody loginBody);
}
