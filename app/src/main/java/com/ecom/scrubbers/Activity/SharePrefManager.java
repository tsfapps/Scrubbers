package com.ecom.scrubbers.Activity;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefManager {


    private static SharePrefManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private SharePrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized SharePrefManager getInstance() {

        if (mInstance == null) {

            mInstance = new SharePrefManager(mCtx);
        }

        return mInstance;
    }


    public void saveUser(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("password", user.getPassword());
        editor.apply();
    }

    public  boolean isLoggedIn (){
        SharedPreferences sharedPreferences = mCtx
                .getSharedPreferences(
                        SHARED_PREF_NAME,Context.MODE_PRIVATE
                );

        return sharedPreferences.getInt("id", -1) != -1;

    }

}
