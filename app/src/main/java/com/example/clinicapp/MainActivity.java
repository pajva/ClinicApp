package com.example.clinicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicapp.pojos.Clinics;
import com.example.clinicapp.pojos.Doctors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView1,recyclerView2;
    private RecyclerView.LayoutManager layoutManager1,layoutManager2;
    private RecyclerAdapterDoctor recyclerAdapter;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private EditText et1;
    private Button clinic_btn,doctor_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        clinic_btn = findViewById(R.id.cbt1);
        doctor_btn = findViewById(R.id.dbt1);
        recyclerView1 = findViewById(R.id.rv1);
        recyclerView2 = findViewById(R.id.rv2);
        layoutManager1  = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager2  = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        getDoctorsList();
        getClinicList();

        try {
        clinic_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ClinicActivity.class);
                startActivity(intent);
            }
        });
        doctor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DoctorActivity.class);
                startActivity(intent);
            }
        });


        }catch (Exception e){
            System.out.println(e);
        }

    }

    private void getClinicList() {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please Wait", "Loading", true);
        ringProgressDialog.setCancelable(true);
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://clinixbooking.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ClinicAPI clinics = r.create(ClinicAPI.class);
        Call<Clinics> call = clinics.getClinicDetails();
        call.enqueue(new Callback<Clinics>() {
            @Override
            public void onResponse(Call<Clinics> call, Response<Clinics> response) {
                Toast.makeText(MainActivity.this, "Response Successfull", Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
                Clinics clinics = response.body();
                recyclerView1.setAdapter(new RecyclerAdapterClinic(clinics));
            }

            @Override
            public void onFailure(Call<Clinics> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Response"+t.getMessage(), Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
            }
        });
    }

    private void getDoctorsList() {

        final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please Wait", "Loading", true);
        ringProgressDialog.setCancelable(true);
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://clinixbooking.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ClinicAPI doctors = r.create(ClinicAPI.class);
        Call<Doctors> call = doctors.getDoctorDetails();
        call.enqueue(new Callback<Doctors>() {
            @Override
            public void onResponse(Call<Doctors> call, Response<Doctors> response) {
//                Toast.makeText(MainActivity.this, "Response Successfull", Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
                Doctors doctors = response.body();
                recyclerView2.setAdapter(new RecyclerAdapterDoctor(doctors));
            }

            @Override
            public void onFailure(Call<Doctors> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Response"+t.getMessage(), Toast.LENGTH_LONG).show();
                ringProgressDialog.dismiss();
            }
        });
    }

}