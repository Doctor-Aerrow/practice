package com.example.dogapi.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomBreeds {
    @GET("breed/hound/images/random/50")
    Call<List<Message>> get50Dogs();
}

