package com.example.letsbuy.API_Interfaces;

import com.example.letsbuy.modals.Post;
import com.example.letsbuy.modals.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Json {
    @GET("posts")
    Call<List<Posts>> getPosts();
}
