package com.developer.firebaseexampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FirebaseRecyclerOptions<Advert> options;
    FirebaseRecyclerAdapter<Advert,AdvertViewHolder> adapter;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        databaseReference = FirebaseDatabase.getInstance().getReference("Advert");

        LoadData();
    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<Advert>().setQuery(databaseReference,Advert.class).build();

        adapter = new FirebaseRecyclerAdapter<Advert, AdvertViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AdvertViewHolder holder, int position, @NonNull Advert model) {

                holder.textView.setText(model.getmName());
                //Picasso.get().load(model.getmImageUrl()).into(holder.imageView);
                Glide.with(getApplicationContext())
                        .load(model.getmImageUrl())
                        .centerCrop()
                        .into(holder.imageView);

            }

            @NonNull
            @Override
            public AdvertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advert_item,parent,false);

                return new AdvertViewHolder(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
