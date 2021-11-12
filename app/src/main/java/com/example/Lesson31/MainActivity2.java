package com.example.Lesson31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    TextInputEditText nameText, passText;
    private String name;
    private final int GALIREA = 12;
    private final int CAMERA = 13;
    private ImageView image;
    private TextView photo;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setinitView();
        imageClik();
        photoClik();

        nameText = findViewById(R.id.com);
        passText = findViewById(R.id.word);

        Intent i = getIntent();
        name = i.getStringExtra(NAME);
        age = i.getIntExtra(AGE,0);
        nameText.setText("" + name);
        passText.setText(""+ age);

    }
    private void photoClik() {
        photo.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA);

        });
    }

    private void imageClik() {
        image.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, GALIREA);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(requestCode == GALIREA && resultCode == RESULT_OK && data != null ){
            Glide.with(this).load(data.getData().toString()).circleCrop().into(image);

        }
        if(requestCode == CAMERA && resultCode == RESULT_OK && data != null ){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
            Glide.with(image).load(imageBitmap).circleCrop().into(image);
        }
    }


    private void setinitView() {
        image = findViewById(R.id.avatar);
        photo = findViewById(R.id.EDIT);
    }

}


