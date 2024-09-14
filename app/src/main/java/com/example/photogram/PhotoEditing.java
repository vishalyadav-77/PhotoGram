package com.example.photogram;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class PhotoEditing extends AppCompatActivity {
    private ImageView imageView, crop, rotate, filter, text;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_photo_editing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = findViewById(R.id.imageView);
        crop = findViewById(R.id.btn_crop);
        rotate = findViewById(R.id.rotate);
        filter = findViewById(R.id.filter);
        text = findViewById(R.id.text);

        // Retrieve the image Uri from intent
        String uriString = getIntent().getStringExtra("imageUri");
        imageUri = Uri.parse(uriString);

        // Load the image into ImageView
        Glide.with(this).load(imageUri).into(imageView);

    }
}