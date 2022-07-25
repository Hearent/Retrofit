package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface JsonPlaceHolder {
// simple get all posts
    @GET("posts")
    Call<List<Post>> getPostv1();

//    define path v2
    @GET("posts")
    Call<List<Post>> getPostv2(@Query("userId") int userId);

//    define querry with more parameters
    @GET("posts")
    Call<List<Post>> getPostv3(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

//    define path v1
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Part("id") int postId);
}
