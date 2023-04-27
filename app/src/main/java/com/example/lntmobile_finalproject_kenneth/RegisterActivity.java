package com.example.lntmobile_finalproject_kenneth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText ID, email, name, pass;
    private Button regis;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        ID=findViewById(R.id.editText_BimbelID);
        email=findViewById(R.id.editText_EmailRegis);
        name=findViewById(R.id.editText_NameRegis);
        pass=findViewById(R.id.editText_PassRegis);
        regis=findViewById(R.id.button_Regis);

        regis.setOnClickListener(view -> {
            goRegister();
        });
    }

    private void goRegister() {
        String newEmail=email.getText().toString().trim();
        String newPass=pass.getText().toString().trim();
        String newName=name.getText().toString().trim();
        String newID=ID.getText().toString().trim();

        if(newEmail.isEmpty()){
            email.setError("Email cannot be empty!");
        }

        if(newPass.isEmpty()){
            pass.setError("Password cannot be empty!");
        }

        if(newName.isEmpty()){
            pass.setError("Name cannot be empty!");
        }

        if(newID.isEmpty()){
            pass.setError("ID cannot be empty!");
        }

        if(!newEmail.isEmpty() && !newPass.isEmpty() && !newName.isEmpty() && !newID.isEmpty()){
            mAuth.createUserWithEmailAndPassword(newEmail, newPass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Data data=new Data(newID, newEmail, newName , newPass);

                                FirebaseDatabase
                                        .getInstance()
                                        .getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(data)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(RegisterActivity.this, "Register succeed!",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Register failed! " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }

    }
}