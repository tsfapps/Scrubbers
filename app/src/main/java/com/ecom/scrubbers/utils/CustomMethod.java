package com.ecom.scrubbers.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CustomMethod {

    public static void callProgress(String strMsg, ProgressDialog progressBar, Context tContext){
        progressBar = new ProgressDialog(tContext);
        progressBar.setMessage(strMsg);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(true);
        progressBar.setProgress(50);
        progressBar.show();
    }
}
