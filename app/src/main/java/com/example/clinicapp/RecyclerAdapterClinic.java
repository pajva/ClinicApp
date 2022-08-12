package com.example.clinicapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicapp.pojos.Clinics;
import com.squareup.picasso.Picasso;

public class RecyclerAdapterClinic extends RecyclerView.Adapter<RecyclerAdapterClinic.MyViewholder>{

    private Clinics clinic_array;
    static ImageView image;

    public RecyclerAdapterClinic(Clinics clinic_array) {
        this.clinic_array = clinic_array;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_clinic,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, @SuppressLint("RecyclerView") int position) {
        try {
            holder.name.setText(clinic_array.getList().get(position).getName());
            holder.location.setText(clinic_array.getList().get(position).getLocation());
            holder.rating.setText(clinic_array.getList().get(position).getRating());
            Picasso.with(image.getContext()).load(clinic_array.getList().get(position).getImage()).into(image);
            holder.view_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder =new AlertDialog.Builder(v.getContext());
                    builder.setTitle("Name : "+clinic_array.getList().get(position).getName());
                    builder.setMessage("Location : "+clinic_array.getList().get(position).getLocation());
//                    ImageView img = new ImageView(v.getContext());
                    Picasso.with(v.getContext()).load(clinic_array.getList().get(position).getImage()).into(image);
                    builder.setView(image);
                    builder.setIcon(R.drawable.cente);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int getItemCount() {
        return clinic_array.getList().size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView name,location,rating,view_all;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ctv1);
            location = itemView.findViewById(R.id.ctv3);
            image = itemView.findViewById(R.id.cimg1);
            rating = itemView.findViewById(R.id.ctv2);
            view_all = itemView.findViewById(R.id.tv4);
        }
    }
}
