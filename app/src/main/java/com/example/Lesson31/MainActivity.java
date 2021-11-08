 package com.example.Lesson31;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

 public class MainActivity extends AppCompatActivity {

     private Button GO;
     private TextInputEditText shift,Username;
     private ImageView image;




     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Username = findViewById(R.id.f1);
         shift = findViewById(R.id.f2);
         image = findViewById(R.id.image);
         GO = findViewById(R.id.GO);
         initListeners();



         Username.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int after, int count ) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before , int count) {

             }

             @RequiresApi(api = Build.VERSION_CODES.M)
             @Override
             public void afterTextChanged(Editable s) {
                 if (Username.getText().toString().length() > 0) {
                     GO.setBackgroundColor(getColor(R.color.black));
                 } else {
                     GO.setBackgroundColor(getColor(R.color.teal_700));
                     {

                     }


                 }

             }

         });
     }

     private void initListeners() {
         Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(image);
     }
 }

