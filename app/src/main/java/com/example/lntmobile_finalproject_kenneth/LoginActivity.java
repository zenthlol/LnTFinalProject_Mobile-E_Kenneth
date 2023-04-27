package com.example.lntmobile_finalproject_kenneth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email, pass;
    private Button login;
    private TextView register;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        email=findViewById(R.id.editText_Email);
        pass=findViewById(R.id.editText_Pass);
        login=findViewById(R.id.button_Login);
        register=findViewById(R.id.text_Regis);

        register.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        login.setOnClickListener(view -> {
            goLogin();
        });
    }

    private void goLogin() {
        String userEmail=email.getText().toString().trim();
        String userPass=pass.getText().toString().trim();

        if(userEmail.isEmpty()){
            email.setError("Email cannot be empty!");
        }

        if(userPass.isEmpty()){
            pass.setError("Password cannot be empty!");
        }

        if(!userEmail.isEmpty() && !userPass.isEmpty()){
            mAuth.signInWithEmailAndPassword(userEmail, userPass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Login Failed" + task.getException()
                                        .getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }
}