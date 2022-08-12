package com.example.clinicapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clinicapp.pojos.Doctors;
import com.squareup.picasso.Picasso;

public class RecyclerAdapterDoctor extends RecyclerView.Adapter<RecyclerAdapterDoctor.MyViewholder> {

    private Doctors doctor_array;
    static ImageView image;

    public RecyclerAdapterDoctor(Doctors doctor_array) {
        this.doctor_array = doctor_array;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_view_doctor,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        try {
            holder.name.setText(doctor_array.getList().get(position).getName());
            holder.location.setText(doctor_array.getList().get(position).getLocation());
            holder.clinicname.setText(doctor_array.getList().get(position).getClinicname());
            holder.rating.setText(doctor_array.getList().get(position).getRating());
            Picasso.with(image.getContext()).load(doctor_array.getList().get(position).getImage()).into(image);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int getItemCount() {
        return doctor_array.getList().size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView name,location,clinicname,rating;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.dtv1);
            location = itemView.findViewById(R.id.dtv3);
            clinicname = itemView.findViewById(R.id.dtv4);
            rating = itemView.findViewById(R.id.dtv2);
            image = itemView.findViewById(R.id.dimg1);
        }
    }
}
