package com.example.pract12;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    Call<Post> getPostWithID(@Path("id") int id);

    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @POST("/posts")
    Call<Post> postData(@Body Post data);
}
