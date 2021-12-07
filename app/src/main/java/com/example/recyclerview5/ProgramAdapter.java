package com.example.recyclerview5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView cName;
        TextView cDescription;
        ImageView cFlags;
        CardView cardView;
        ImageView deleteData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cName = itemView.findViewById(R.id.textView_1);
            cDescription = itemView.findViewById(R.id.textView_2);
            cFlags = itemView.findViewById(R.id.demoIV);
            cardView = itemView.findViewById(R.id.cardView);
            deleteData = itemView.findViewById(R.id.delete);

            deleteData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countryDetails.remove(getAdapterPosition());  //These 3 lines inside onclick are for delete mechanism
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),countryDetails.size());
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
        holder.cName.setText(item.getCountryName());
        holder.cDescription.setText(item.getCountryDescription());
        holder.cFlags.setImageResource(item.getCountryFlags());
    }

    @Override
    public int getItemCount() {
        return countryDetails.size();
    }
}



