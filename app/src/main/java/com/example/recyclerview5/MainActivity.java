package com.example.recyclerview5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<CountryPojo> countryList=new ArrayList<>();
    Button addButton;

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

        addButton=findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_layout_add_dialog);
                EditText name=dialog.findViewById(R.id.editText_1);
                EditText des=dialog.findViewById(R.id.editText_2);

                ImageView add=dialog.findViewById(R.id.ivAdd); //48-62 lines are for add feature
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nameAdd=name.getText().toString();
                        String desAdd=des.getText().toString();
                        countryList.add(new CountryPojo(nameAdd,desAdd));
                        programAdapter.notifyItemInserted(countryList.size()-1);  //last index is size-1
                        recyclerView.scrollToPosition(countryList.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        programAdapter=new ProgramAdapter(this,countryList);
        recyclerView.setAdapter(programAdapter);
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(),"App has been restarted",Toast.LENGTH_LONG).show();
        super.onResume();
    }
}