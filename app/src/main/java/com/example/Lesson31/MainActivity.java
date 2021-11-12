 package com.example.Lesson31;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

 public class MainActivity extends AppCompatActivity {

     private Button GO;
     private TextInputEditText shift,Username;
     private TextInputLayout user,pass;
     private ImageView image;
     private String login;
     private int lock;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Username = findViewById(R.id.f2);
         shift = findViewById(R.id.f1);
         image = findViewById(R.id.image);
         GO = findViewById(R.id.GO);
         user = findViewById(R.id.Username);
         pass = findViewById(R.id.Password);
         GO.setOnClickListener(view -> go_j());
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
         Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66efww08174bb7455c4a8a2d2f.jpg").into(image);


     }

     public void requestFocus(View view){
         if (view.requestFocus()){
             getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
         }
     }
     private boolean validate_name(){
         if (Username.getText().toString().trim().isEmpty()) {
             user.setError("EnterName");
             requestFocus(Username);
             return false;
         }
         return true;


     }
     private boolean validate_pass(){
         if (shift.getText().toString().trim().isEmpty()){
             pass.setError("Ввидите пароль!");
             requestFocus(shift);
             return false;
         }else {
             if (shift.getText().toString().trim().length() < 6){
                 pass.setError("Пароль не должен быть меньше 6");
                 requestFocus(shift);
                 return false;
             }
         }
     return true;


     }
     private void go_j(){
         if (!validate_name()){
             return;
         }
         if (!validate_pass()) {
             return;
         }

     String sname = Username.getText().toString().trim()+"";
     String snam = shift.getText().toString().trim()+"";
     GO.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             senDate();
         }
     });


     }
     public void senDate(){
         login = Username.getText().toString().trim();
         lock = Integer.parseInt(shift.getText().toString().trim());
         Intent i = new Intent(MainActivity.this,MainActivity2.class);

         i.putExtra(MainActivity2.NAME,login);
         i.putExtra(MainActivity2.AGE,lock);

         startActivity(i);
     }
     }



