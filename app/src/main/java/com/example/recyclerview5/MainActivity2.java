package com.example.recyclerview5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewC_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewC_Name=findViewById(R.id.tv_Show_C_Name);

        textViewC_Name.setText(getIntent().getStringExtra("passCountryName"));


        textViewC_Name.setOnClickListener(new View.OnClickListener() {  //to redirect to wikipedia when country is clicked
            @Override
            public void onClick(View v) {
                String url="https://en.wikipedia.org/wiki/"+textViewC_Name.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}