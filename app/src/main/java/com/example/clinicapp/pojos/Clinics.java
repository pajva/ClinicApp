package com.example.clinicapp.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Clinics {

    @SerializedName("clinics")
    private ArrayList<Clinic>list;

    public ArrayList<Clinic> getList() {
        return list;
    }

    public void setList(ArrayList<Clinic> list) {
        this.list = list;
    }
}
