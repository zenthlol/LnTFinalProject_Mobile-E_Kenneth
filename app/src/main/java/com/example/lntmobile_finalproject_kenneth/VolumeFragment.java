package com.example.lntmobile_finalproject_kenneth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class VolumeFragment extends Fragment {

    private EditText sideCube, baseLengthPyramid, baseWidthPyramid, heightPyramid, radiusCylinder, heightCylinder;
    private Button calcCube, calcPyramid, calcCylinder;
    private TextView resCube, resPyramid, resCylinder;
    Double num1, num2, num3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_volume, container, false);

        sideCube=view.findViewById(R.id.editText_sideCube);
        calcCube=view.findViewById(R.id.button_calcCube);
        resCube=view.findViewById(R.id.text_resCube);

        baseLengthPyramid=view.findViewById(R.id.editText_baseLenPyramid);
        baseWidthPyramid=view.findViewById(R.id.editText_baseWidPyramid);
        heightPyramid=view.findViewById(R.id.editText_heightPyramid);
        calcPyramid=view.findViewById(R.id.button_calcPyramid);
        resPyramid=view.findViewById(R.id.text_resPyramid);

        radiusCylinder=view.findViewById(R.id.editText_radiusCylinder);
        heightCylinder=view.findViewById(R.id.editText_heightCylinder);
        calcCylinder=view.findViewById(R.id.button_calcCylinder);
        resCylinder=view.findViewById(R.id.text_resCylinder);

        calcCube.setOnClickListener(view1 -> {
            num1=Double.parseDouble(sideCube.getText().toString());
            Double result=num1*num1*num1;
            resCube.setText(String.valueOf(result));
        });

        calcPyramid.setOnClickListener(view1 -> {
            num1=Double.parseDouble(baseLengthPyramid.getText().toString());
            num2=Double.parseDouble(baseWidthPyramid.getText().toString());
            num3=Double.parseDouble(heightPyramid.getText().toString());
            Double result=(num1*num2*num3)/3;
            resPyramid.setText(String.valueOf(result));
        });

        calcCylinder.setOnClickListener(view1 -> {
            num1=Double.parseDouble(radiusCylinder.getText().toString());
            num2=Double.parseDouble(heightCylinder.getText().toString());
            Double result=Math.PI*num1*num1*num2;
            resCylinder.setText(String.valueOf(result));
        });

        return view;
    }
}