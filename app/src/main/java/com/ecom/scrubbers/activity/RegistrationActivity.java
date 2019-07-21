package com.ecom.scrubbers.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ecom.scrubbers.R;

import com.ecom.scrubbers.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etemail, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etemail = findViewById(R.id.et_email_signup);
        etpass = findViewById(R.id.et_pass_signup);


        findViewById(R.id.btn_reg).setOnClickListener(this);
        findViewById(R.id.tv_log_signup).setOnClickListener(this);


    }

    private void userSignUp() {

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

        Call<ModelRegister> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, password);

        call.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {


                ModelRegister s = response.body();


                Log.d("swetabh", "Respose:" + response.message());
                Log.d("swetabh", "Respose:" + response.toString());

                Toast.makeText(getApplicationContext(),s.getMessage(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {


                Toast.makeText(getApplicationContext(), "Failed To Resigter Check Network Connectivity ", Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reg:
                userSignUp();
                break;

            case R.id.tv_log_signup:
                break;
        }

    }
}
