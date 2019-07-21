package com.ecom.scrubbers.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ecom.scrubbers.R;

import com.ecom.scrubbers.api.RetrofitClient;
import com.ecom.scrubbers.model.user.ModelLogin;
import com.ecom.scrubbers.utils.Constant;
import com.ecom.scrubbers.utils.CustomMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Context tContext;
    private EditText etemail, etpass;
    private Button btn;
   private ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.et_email_log);
        etpass = findViewById(R.id.et_pass_log);
        btn = findViewById(R.id.btn_login);
        tContext = getApplicationContext();

    }


    private void userLogin() {

        String email = etemail.getText().toString().trim();

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

                ModelLogin tModel = response.body();
                Log.d(Constant.TAG, "Login Response Message : "+response.message());
                Log.d(Constant.TAG, "Login Response : "+response.errorBody());
                Log.d(Constant.TAG, "Login Call : "+call.toString());


                CustomMethod.callProgress(Constant.LOGIN_MSG, progressBar, tContext);
                Toast.makeText(LoginActivity.this, tModel.getMessage(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {

                Log.d(Constant.TAG, "Login Failure : "+t);
            }
        });


    }


    public void clickView(View view) {


        switch (view.getId()) {
            case R.id.btn_login:
                userLogin();
                break;
        }
    }


    public void textClick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }


}
