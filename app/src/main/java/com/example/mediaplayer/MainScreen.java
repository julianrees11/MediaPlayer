package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screenxml);
        Button button = (Button) findViewById(R.id.btnSearch);
        search = findViewById(R.id.etSearch);



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(MainScreen.this, com.example.mediaplayer.MainActivity.class);
////                String name = search.getText().toString();
////                intent.putExtra("song", name);
////                startActivity(intent);
//
//            }
//        });


    }
}
