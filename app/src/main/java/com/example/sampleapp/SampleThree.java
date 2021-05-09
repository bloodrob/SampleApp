package com.example.sampleapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SampleThree extends Fragment{
    //empty constructor
    public SampleThree(){

    }

    //inflate layout for this fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        return inflater.inflate(R.layout.fragment_sample_three, container, false);
    }
}