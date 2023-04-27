package com.example.lntmobile_finalproject_kenneth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class CounterFragment extends Fragment {

    private TextView number;
    private Button plus, minus, reset;
    private String count;

    private static final String MY_PREFERENCES1 = "aa";
    private static final String PREF_TOTAL_KEY1 = "bb";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        number=view.findViewById(R.id.text_number);
        plus=view.findViewById(R.id.button_plus);
        minus=view.findViewById(R.id.button_minus);
        reset=view.findViewById(R.id.button_reset);

        SharedPreferences pref1=getActivity().getSharedPreferences(MY_PREFERENCES1, Context.MODE_PRIVATE);


        plus.setOnClickListener(view1 -> {
            String newText=Integer.toString(Integer.parseInt(number.getText().toString())+1);


            SharedPreferences.Editor editor=pref1.edit();
            editor.putString(PREF_TOTAL_KEY1, newText);
            editor.commit();
            number.setText(newText);

        });

        minus.setOnClickListener(view1 -> {
            if(Integer.parseInt(number.getText().toString()) != 0){
                String newText=Integer.toString(Integer.parseInt(number.getText().toString())-1);


                SharedPreferences.Editor editor=pref1.edit();
                editor.putString(PREF_TOTAL_KEY1, newText);
                editor.commit();
                number.setText(newText);
            }
        });

        reset.setOnClickListener(view1 -> {
            number.setText("0");
            String test=number.getText().toString();
            SharedPreferences.Editor editor=pref1.edit();
            editor.putString(PREF_TOTAL_KEY1, test);
            editor.commit();
        });

        return view;
    }
}