package com.example.clinicapp.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Doctors {

    @SerializedName("doctors")
    private ArrayList<Doctor> list;

    public ArrayList<Doctor> getList() {
        return list;
    }

    public void setList(ArrayList<Doctor> list) {
        this.list = list;
    }
}
