package com.example.sampleapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SampleOne extends Fragment{
    //for checking button onclick
    int BtnStatus = 0;
    TextView FragText;
    //empty constructor
    public SampleOne(){

    }

    //inflate layout for this fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        //init view
        View inflateView;
        //for button
         final Button BtnCat1;
         Button BtnCat2;
         Button BtnCat3;
         Button BtnCat4;
        inflateView = inflater.inflate(R.layout.fragment_sample_one,container,false);

        //button work
        BtnCat1 = inflateView.findViewById(R.id.cat1_btn_frag_sample_one);
      //  BtnCat1.setBackgroundDrawable(getResources().getDrawable(R.drawable.menu_button_selector));
        BtnCat2 = inflateView.findViewById(R.id.cat2_btn_frag_sample_one);
        BtnCat3 = inflateView.findViewById(R.id.cat3_btn_frag_sample_one);
        BtnCat4 = inflateView.findViewById(R.id.cat4_btn_frag_sample_one);
        FragText = inflateView.findViewById(R.id.sampleText_fragment_sample_one);

        BtnCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragText.setText("This Is The 1st Tab Fragment, And clicked button 1");
            }
        });
        BtnCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragText.setText("This Is The 1st Tab Fragment, And clicked button 2");
            }
        });
        BtnCat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragText.setText("This Is The 1st Tab Fragment, And clicked button 3");
            }
        });
        BtnCat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragText.setText("This Is The 1st Tab Fragment, And clicked button 4");
            }
        });

        return inflateView;
    }
}