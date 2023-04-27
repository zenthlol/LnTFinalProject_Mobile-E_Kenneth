package com.example.lntmobile_finalproject_kenneth;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {


    private Button button_logout;
    private FirebaseUser user;
    private DatabaseReference dataRef;
    private String userUID;
    private TextView toolsBimbelID, toolsName, toolsEmail;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth=FirebaseAuth.getInstance();
        button_logout=view.findViewById(R.id.buttonLogout);
        toolsBimbelID=view.findViewById(R.id.tools_bimbelID);
        toolsName=view.findViewById(R.id.tools_name);
        toolsEmail=view.findViewById(R.id.tools_email);

        button_logout.setOnClickListener(view1 -> {
            goLogout(view);
        });

        user=FirebaseAuth.getInstance().getCurrentUser();
        dataRef= FirebaseDatabase.getInstance().getReference("Users");
        userUID=user.getUid();
        dataRef.child(userUID)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Data dataProfile=snapshot.getValue(Data.class);

                        if(dataProfile != null){
                            String userID=dataProfile.getID();
                            String name=dataProfile.getName();
                            String email=dataProfile.getEmail();

                            toolsBimbelID.setText(userID);
                            toolsName.setText(name);
                            toolsEmail.setText(email);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
                    }
                });


        return view;
    }

    private void goLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getActivity(), StartPageActivity.class));
    }
}