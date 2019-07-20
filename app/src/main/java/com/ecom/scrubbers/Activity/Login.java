package com.ecom.scrubbers.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ecom.scrubbers.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText etemail, etpass;
    private Button btn;
    ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.et_email_log);
        etpass = findViewById(R.id.et_pass_log);
        btn = findViewById(R.id.btn_login);

    }


    private void userLogin() {

        String email = etemail.getText().toString().trim();

        Log.d("swetabh", "Respose:" + email.toString());


        String password = etpass.getText().toString().trim();

        if (email.isEmpty()) {
            etemail.setError("Email is required");
            etemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etemail.setError("Enter a valid email");
            etemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etpass.setError("Password required");
            etpass.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etpass.setError("Password should be 6 character long");
            etpass.requestFocus();
            return;

        }

        Call<ModelLogin> call = RetrofitClient
                .getInstance()
                .getApi()
                .createLogin(email, password);

        call.enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {

                ModelLogin m = response.body();
                Toast.makeText(Login.this, m.getMessage(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {

            }
        });


    }


    public void clickView(View view) {


        progressBar = new ProgressDialog(this);
        progressBar.setMessage("LOGIN IN PROGRESS");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(true);
        progressBar.setProgress(50);
        progressBar.show();


        switch (view.getId()) {
            case R.id.btn_login:
                userLogin();
                break;
        }
    }


    public void textClick(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }


}
