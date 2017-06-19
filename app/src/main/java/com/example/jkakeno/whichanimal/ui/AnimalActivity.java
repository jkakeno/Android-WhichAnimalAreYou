package com.example.jkakeno.whichanimal.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.jkakeno.whichanimal.R;

public class AnimalActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal);
//Initialize image view
        ImageView mImageView = (ImageView) findViewById(R.id.animalmageView);
//Get the drawable id for each animals via intent
        int dolphin = getIntent().getIntExtra("animal", R.drawable.dolphin);
        int elephant = getIntent().getIntExtra("animal", R.drawable.elephant);
        int monkey = getIntent().getIntExtra("animal", R.drawable.monkey);
        int redpanda = getIntent().getIntExtra("animal", R.drawable.redpanda);
        int tiger = getIntent().getIntExtra("animal", R.drawable.tiger);
//Display the drawable using the drawable id from drawable resource on the image view
        mImageView.setImageResource(dolphin);
        mImageView.setImageResource(elephant);
        mImageView.setImageResource(monkey);
        mImageView.setImageResource(redpanda);
        mImageView.setImageResource(tiger);
    }
}
