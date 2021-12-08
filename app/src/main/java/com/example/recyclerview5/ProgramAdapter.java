package com.example.recyclerview5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {
    Context context;
    ArrayList<CountryPojo> countryDetails;

    public ProgramAdapter(Context context,ArrayList<CountryPojo> countryDetails){
        this.context=context;
        this.countryDetails=countryDetails;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cFlags;
        CardView cardView;
        ImageView deleteData;
        TextView cNameTV;
        TextView cDescriptionTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cNameTV = itemView.findViewById(R.id.textView_1);
            cDescriptionTV = itemView.findViewById(R.id.textView_2);
            cFlags = itemView.findViewById(R.id.demoIV);
            cardView = itemView.findViewById(R.id.cardView);
            deleteData = itemView.findViewById(R.id.delete);

            deleteData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);  //45-65 are for both Alertdialog & delete mechanism
                    alertdialog.setTitle("Delete");
                    alertdialog.setMessage("Are you sure to delete this country?");
                    alertdialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertdialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            countryDetails.remove(getAdapterPosition());  //These 3 lines inside onclick are for delete mechanism
                            notifyItemRemoved(getAdapterPosition());
                            notifyItemRangeChanged(getAdapterPosition(),countryDetails.size());
                        }
                    });
                    AlertDialog dialog=alertdialog.create();
                    dialog.show();
                }
            });
        }
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.custom_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        CountryPojo item=countryDetails.get(position);
        holder.cNameTV.setText(item.getCountryName());
        holder.cDescriptionTV.setText(item.getCountryDescription());
        holder.cFlags.setImageResource(item.getCountryFlags());
    }

    @Override
    public int getItemCount() {
        return countryDetails.size();
    }
}



