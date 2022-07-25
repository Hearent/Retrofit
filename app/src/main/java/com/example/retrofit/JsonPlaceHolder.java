package com.example.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolder {

    // simple get all posts
    @GET("posts")
    Call<List<Post>> getPostv1();

    //    define path v1
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Part("id") int postId);

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

    //define querry with unlimited parameters
    @GET("posts")
    Call<List<Post>> getPostv4(@QueryMap Map<String, String> parameters);

    //get request from using URL
    @GET
    Call<List<Comment>> getCommentsv2(@Url String url);

    //post request
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //post request v2
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostv2(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );
    //post request v3
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostv3(@FieldMap Map<String, String> fields);

    //put method
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    //patch method
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);
}
