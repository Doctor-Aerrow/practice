package com.example.dogapi.data;

import android.widget.Toast;

import com.example.dogapi.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogApi {
    private static DogApi instance;
    private static final String BASE_URL = "https://dog.ceo/api/";
    private Retrofit mRetrofit;

    public static DogApi getInstance(){
        instance = new DogApi();
        return instance;
    }

    public DogApi() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RandomBreeds randomBreeds = mRetrofit.create(RandomBreeds.class);

        Call<List<Message>> dogs = randomBreeds.get50Dogs();

        dogs.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if(response.isSuccessful()) {
                    Message message = (Message) response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }


}
