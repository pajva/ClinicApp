package com.example.clinicapp;

import com.example.clinicapp.pojos.Clinic;
import com.example.clinicapp.pojos.Clinics;
import com.example.clinicapp.pojos.Doctor;
import com.example.clinicapp.pojos.Doctors;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClinicAPI {

    @GET("mobileapi/master/get_homepage?language_id=1&token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTI0IiwiaWF0IjoxNjM4NDM5NjE0fQ.7qm4dyI1G3kMf-VAwWrNS_F_D2LjZDX9Wew-HBYUjd4&user_id=124")
    Call<Doctors> getDoctorDetails();

    @GET("mobileapi/master/get_homepage?language_id=1&token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTI0IiwiaWF0IjoxNjM4NDM5NjE0fQ.7qm4dyI1G3kMf-VAwWrNS_F_D2LjZDX9Wew-HBYUjd4&user_id=124")
    Call<Clinics> getClinicDetails();

}
