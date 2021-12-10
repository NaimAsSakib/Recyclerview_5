package com.example.recyclerview5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
        ImageView editData;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cNameTV = itemView.findViewById(R.id.textView_1);
            cDescriptionTV = itemView.findViewById(R.id.textView_2);
            cFlags = itemView.findViewById(R.id.demoIV);
            cardView = itemView.findViewById(R.id.cardView);
            editData=itemView.findViewById(R.id.ivEdit);
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

        holder.editData.setOnClickListener(new View.OnClickListener() {   //90-114 is for edit mechanism
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.custom_layout_edit_dialog);
                EditText updateName=dialog.findViewById(R.id.editText_1);
                EditText updateDesc=dialog.findViewById(R.id.editText_2);
                ImageView editDone=dialog.findViewById(R.id.ivUpdate);

                /*name.setText(countryDetails.get(position).countryName);
                des.setText(countryDetails.get(position).countryDescription);*/

                editDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nameUpdated=updateName.getText().toString();
                        String desUpdated=updateDesc.getText().toString();
                        countryDetails.set(position,new CountryPojo(nameUpdated,desUpdated));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.cNameTV.setOnClickListener(new View.OnClickListener() {  //117-124 for showing country name on clicking that name
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("passCountryName",item.getCountryName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryDetails.size();
    }
}



