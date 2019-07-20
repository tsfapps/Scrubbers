package com.ecom.scrubbers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.ecom.scrubbers.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CategoryAdapter adapter;
    private List<ModelCategory>  modelCategoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //recyclerView details

        recyclerView = findViewById(R.id.rcv);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        details();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action


        } else if (id == R.id.pickup_req) {


        } else if (id == R.id.pickup_list) {


            Intent i = new Intent(this, PickupActivity.class);
            startActivity(i);


        } else if (id == R.id.rate_chart) {

        } else if (id == R.id.del_list) {

        } else if (id == R.id.del_list) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void details() {
        Api api = RetrofitClient.getInstance().getApi();
        Call<List<ModelCategory>> listCall = api.getCat();

        listCall.enqueue(new Callback<List<ModelCategory>>() {
            @Override
            public void onResponse(Call<List<ModelCategory>> call, Response<List<ModelCategory>> response) {

                modelCategoryList = response.body();
                adapter = new CategoryAdapter(getApplicationContext(),modelCategoryList);
                recyclerView.setAdapter(adapter);


                Log.d("swetabh", "Respose:" + response.message());

                Toast.makeText(getApplicationContext(), "sucess ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ModelCategory>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

