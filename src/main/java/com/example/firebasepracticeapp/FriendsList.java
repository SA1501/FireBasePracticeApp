 package com.example.firebasepracticeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

 public class FriendsList extends AppCompatActivity {

     RecyclerView recyclerView;
     RecyclerViewAdapter adapter;
     List<User> users;
     ImageView img;
     DatabaseReference db;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_friendslist);

         recyclerView = findViewById(R.id.recyclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         users = new ArrayList<>();
         adapter = new RecyclerViewAdapter(this,users);
         recyclerView.setAdapter(adapter);
         img = (ImageView) findViewById(R.id.profileImageView);

         this.gettingData();
         //circularIMageView();


     }

     private void gettingData() {

         db = FirebaseDatabase.getInstance().getReference().child("Employees");

         db.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 // This method is called once with the initial value and again
                 // whenever data at this location is updated.
                 for(DataSnapshot snap : dataSnapshot.getChildren()){


                     User model = snap.getValue(User.class);
                     users.add(model);
                     adapter.notifyDataSetChanged();

                 }
               //  circularIMageView();
             }


//                 @Override
             public void onCancelled(DatabaseError error) {
                 // Failed to read value
                 Toast.makeText(getApplicationContext(),"Error Occured in Loading",Toast.LENGTH_LONG).show();
                // Log.w(TAG, "Failed to read value.", error.toException());
             }
         });
     }

        private void circularIMageView(){
        User u = new User();

        u.setFirstName("Hamza");
        u.setLastName("Khalid");
        u.setEmailAddress("hk@gmail.com");
        u.setJobTitleName("iOS & Android Developer/DataScientist");
        u.setPhoneNumber("0333-6608211");
        u.setPreferredFullName("https://pkimgcdn.peekyou.com/3efb7bdd3ccfc1fc5eaa600d8233e686.jpeg");
        db.push().setValue(u);

        }


 }
