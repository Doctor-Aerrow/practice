package com.example.dogapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dogapi.data.DogApi;
import com.squareup.picasso.Picasso;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private String[] dogs;


    public Adapter(String[] dogs) {
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.get().load(dogs[i]).into(myViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return dogs.length;
    }


    //==========================================================================
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.dog_picture);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
