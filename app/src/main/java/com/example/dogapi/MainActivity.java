package com.example.dogapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dogapi.data.DogApi;
import com.example.dogapi.data.Message;


public class MainActivity extends AppCompatActivity {

    private RecyclerView dogList;
    private Adapter dogAdapter;
    private Message messege;
    private String[] dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogList = findViewById(R.id.dog_list);

        new MyTask().execute();

    }

    class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            DogApi.getInstance();
            dogs = messege.getMessage();
            dogAdapter = new Adapter(dogs);

            LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
            dogList.setLayoutManager(manager);

            dogList.setAdapter(dogAdapter);
            return null;
        }
    }
}
