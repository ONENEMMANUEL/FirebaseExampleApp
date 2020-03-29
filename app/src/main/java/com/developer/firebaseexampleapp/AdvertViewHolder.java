package com.developer.firebaseexampleapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AdvertViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public AdvertViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view_advert);
        textView = itemView.findViewById(R.id.text_view_advert);
    }
}
