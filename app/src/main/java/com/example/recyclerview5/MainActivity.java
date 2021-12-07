package com.example.recyclerview5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<CountryPojo> countryList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.country_RV);
        countryList.add(new CountryPojo("Azerbaijan","Azerbaijan is located near black sea",R.drawable.azerbaijan));
        countryList.add(new CountryPojo("Bangladesh","Bangladesh is a riverine country",R.drawable.bangladesh));
        countryList.add(new CountryPojo("Brazil","Brazil is famous for Amazon",R.drawable.brazil));
        countryList.add(new CountryPojo("Canada","Canada is a secular country",R.drawable.canada));
        countryList.add(new CountryPojo("Germany","Germany is a rich country in Europe",R.drawable.germany));
        countryList.add(new CountryPojo("Portugal","Portugal is famous for cr7",R.drawable.portugal));
        countryList.add(new CountryPojo("South-Africa","South-Africa is in Africa",R.drawable.south_africa));
        countryList.add(new CountryPojo("Sri-Lanka","Sri-Lanka is an island",R.drawable.sri_lanka));
        countryList.add(new CountryPojo("Turkey","Turkey is a Muslim country",R.drawable.turkey));

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        programAdapter=new ProgramAdapter(this,countryList);
        recyclerView.setAdapter(programAdapter);
    }
}