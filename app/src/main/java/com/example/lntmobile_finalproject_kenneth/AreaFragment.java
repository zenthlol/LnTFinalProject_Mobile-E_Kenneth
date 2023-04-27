package com.example.lntmobile_finalproject_kenneth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AreaFragment extends Fragment {

    Double num1, num2;
    private EditText baseSquare, baseTriangle, heightTriangle, radiusCircle;
    private Button calcSquare, calcCircle, calcTriangle;
    private TextView resSquare,resCircle, resTriangle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_area, container, false);

        baseSquare=view.findViewById(R.id.editText_baseSquare);
        baseTriangle=view.findViewById(R.id.editText_baseTriangle);
        heightTriangle=view.findViewById(R.id.editText_heightTriangle);
        radiusCircle=view.findViewById(R.id.editText_radiusCircle);
        calcSquare=view.findViewById(R.id.button_calcSquare);
        calcTriangle=view.findViewById(R.id.button_calcTriangle);
        calcCircle=view.findViewById(R.id.button_calcCircle);
        resSquare=view.findViewById(R.id.text_resSquare);
        resTriangle=view.findViewById(R.id.text_resTriangle);
        resCircle=view.findViewById(R.id.text_resCircle);

        calcSquare.setOnClickListener(views -> {
            num1=Double.parseDouble(baseSquare.getText().toString());
            Double result=num1*num1;
            resSquare.setText(String.valueOf(result));
        });

        calcTriangle.setOnClickListener(views -> {
            num1=Double.parseDouble(baseTriangle.getText().toString());
            num2=Double.parseDouble(heightTriangle.getText().toString());
            Double result=(num1*num2)/2;
            resTriangle.setText(String.valueOf(result));
        });

        calcCircle.setOnClickListener(views -> {
            num1=Double.parseDouble(radiusCircle.getText().toString());
            Double result=Math.PI*num1*num1;
            resCircle.setText(String.valueOf(result));
        });

        return view;
    }
}