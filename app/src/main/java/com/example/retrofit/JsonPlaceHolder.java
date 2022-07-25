package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Post>> getPost();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Part("id") int postId);
}
