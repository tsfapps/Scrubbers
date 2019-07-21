package com.ecom.scrubbers.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ecom.scrubbers.R;

import com.ecom.scrubbers.api.RetrofitClient;
import com.ecom.scrubbers.model.ModelCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickupActivity extends AppCompatActivity {

    EditText etreq, ettime, etdate;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        etreq = findViewById(R.id.et_req);
        ettime = findViewById(R.id.et_time);
        etdate = findViewById(R.id.et_date);

        btn = findViewById(R.id.btn_submit);

    }


    private void userSubmit() {

        String req = etreq.getText().toString().trim();
        String time = ettime.getText().toString().trim();
        String date = etdate.getText().toString().trim();


        Call<ModelCategory> call = RetrofitClient
                .getInstance()
                .getApi()
                .userSubmit(req, time, date);

        call.enqueue(new Callback<ModelCategory>() {
            @Override
            public void onResponse(Call<ModelCategory> call, Response<ModelCategory> response) {

                ModelCategory s = response.body();

                Toast.makeText(getApplicationContext(), s.getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelCategory> call, Throwable t) {


                Toast.makeText(getApplicationContext(), "Failed to Submit Check Network Connectivity", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void clickView(View view) {

        switch (view.getId()) {
            case R.id.btn_submit:
                userSubmit();
                break;
        }
    }
}
