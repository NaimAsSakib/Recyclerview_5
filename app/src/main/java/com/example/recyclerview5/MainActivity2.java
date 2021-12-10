package com.example.recyclerview5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewC_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewC_Name=findViewById(R.id.tv_Show_C_Name);

        textViewC_Name.setText(getIntent().getStringExtra("passCountryName"));
    }
}