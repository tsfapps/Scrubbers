package com.ecom.scrubbers.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ecom.scrubbers.utils.Constant;

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private Context tContext;

    private Editor tEditor;


    public SharedPrefManager(Context tContext) {
        this.tContext = tContext;
    }

    public static synchronized SharedPrefManager getInstance(Context tCtx){
        if (mInstance == null){
            mInstance = new SharedPrefManager(tCtx);

        }
        return mInstance;
    }

    public void setUserData( String userId, String userName , String pubgUserName , String phoneNo ,
                             String email , String dob , String referralCode, String noOfReferrals,
                             String totalAddedAmount, String walletAmount, String noOfMatchPlayed, String totalEarnedMatch, String totalEarnedRefferals,
       String totalKills, String rank, String pubgLevel, String doj, String profilePic, String status) {
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_WALLET, walletAmount);
        tEditor.putString(Constant.USER_ID, userId);
        tEditor.putString(Constant.USER_NAME, userName);
        tEditor.putString(Constant.USER_PUBG_NAME, pubgUserName);
        tEditor.putString(Constant.USER_DOB, dob);
        tEditor.putString(Constant.USER_PHONE_NO, phoneNo);
        tEditor.putString(Constant.USER_EMAIL, email);
        tEditor.putString(Constant.USER_REFERRAL_CODE, referralCode);
        tEditor.putString(Constant.USER_NO_OF_REFERRAL, noOfReferrals);
        tEditor.putString(Constant.USER_MATCH_PLAYED, noOfMatchPlayed);
        tEditor.putString(Constant.USER_TOTAL_EARNED, totalEarnedMatch);
        tEditor.putString(Constant.USER_BONUS, totalEarnedRefferals);
        tEditor.putString(Constant.USER_ADDED_AMOUNT, totalAddedAmount);
        tEditor.putString(Constant.USER_TOTAL_KILL, totalKills);
        tEditor.putString(Constant.USER_RANK, rank);
        tEditor.putString(Constant.USER_LEVEL, pubgLevel);
        tEditor.putString(Constant.USER_DOJ, doj);
        tEditor.putString(Constant.USER_PRO_PIC, profilePic);
        tEditor.putString(Constant.USER_STATUS, status);
        tEditor.apply();

    }


    public void clearUserData(){
        SharedPreferences tPref = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tPref.edit();

        tEditor.remove(Constant.USER_WALLET);
        tEditor.remove(Constant.USER_ID);
        tEditor.remove(Constant.USER_NAME);
        tEditor.remove(Constant.USER_PUBG_NAME);
        tEditor.remove(Constant.USER_DOB);
        tEditor.remove(Constant.USER_PHONE_NO);
        tEditor.remove(Constant.USER_EMAIL);
        tEditor.remove(Constant.USER_REFERRAL_CODE);
        tEditor.remove(Constant.USER_NO_OF_REFERRAL);
        tEditor.remove(Constant.USER_MATCH_PLAYED);
        tEditor.remove(Constant.USER_TOTAL_EARNED);
        tEditor.remove(Constant.USER_BONUS);
        tEditor.remove(Constant.USER_ADDED_AMOUNT);
        tEditor.remove(Constant.USER_TOTAL_KILL);
        tEditor.remove(Constant.USER_RANK);
        tEditor.remove(Constant.USER_LEVEL);
        tEditor.remove(Constant.USER_DOJ);
        tEditor.remove(Constant.USER_PRO_PIC);
        tEditor.remove(Constant.USER_STATUS);
        tEditor.apply();
        tEditor.clear();
    }


    public void clearKill(){
        SharedPreferences sharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = sharedPreferences.edit();
        tEditor.remove(Constant.USER_TOTAL_KILL);
        tEditor.apply();
    }
    public void clearUserEared(){
        SharedPreferences sharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = sharedPreferences.edit();
        tEditor.remove(Constant.USER_TOTAL_EARNED);
        tEditor.apply();
    }
    public void clearUserMatchPlayed(){
        SharedPreferences sharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = sharedPreferences.edit();
        tEditor.remove(Constant.USER_MATCH_PLAYED);
        tEditor.apply();
    }

    public void setUserKill(String strKill){
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_TOTAL_KILL, strKill);
        tEditor.apply();
    }
    public void setUserEarned(String strEarned){
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_TOTAL_EARNED, strEarned);
        tEditor.apply();
    }
    public void setUserMatchPlayed(String strMatchPlayed){
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_MATCH_PLAYED, strMatchPlayed);
        tEditor.apply();
    }




    public void clearWallet(){
        SharedPreferences sharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = sharedPreferences.edit();
        tEditor.remove(Constant.USER_WALLET);
        tEditor.apply();
    }

    public void setUserWallet(String strWallet){
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_WALLET, strWallet);
        tEditor.apply();
    }
    public String getUserWallet(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_WALLET, Constant.EMPTY);
    }

    public void clearBonus(){
        SharedPreferences sharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = sharedPreferences.edit();
        tEditor.remove(Constant.USER_BONUS);
        tEditor.apply();
    }

    public void setUserBonus(String strWallet){
        SharedPreferences tSharedPreferences = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        tEditor = tSharedPreferences.edit();
        tEditor.putString(Constant.USER_BONUS, strWallet);
        tEditor.apply();
    }
    public String getUserBonus(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_BONUS, Constant.EMPTY);
    }
    public String getUserId(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_ID, Constant.EMPTY);
    }
    public String getUserName(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_NAME, Constant.EMPTY);
    }
    public String getUserDob(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_DOB, Constant.EMPTY);
    }
    public String getUserPhone(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_PHONE_NO, Constant.EMPTY);
    }
    public String getUserEmail(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
        return sp.getString(Constant.USER_EMAIL, Constant.EMPTY);
    }

    public String getUserReferralCode(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_REFERRAL_CODE, Constant.EMPTY);
    }
    public String getUserNoOfReferreal(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_NO_OF_REFERRAL, Constant.EMPTY);
    }
    public String getUserNoOfMatch(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_MATCH_PLAYED, Constant.EMPTY);
    }
    public String getUserTotalEarned(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_TOTAL_EARNED, Constant.EMPTY);
    }
    public String getUserAddedAmount(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_ADDED_AMOUNT, Constant.EMPTY);
    }
    public String getUserTotalKill(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_TOTAL_KILL, Constant.EMPTY);
    }
    public String getPubgName(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_PUBG_NAME, Constant.EMPTY);
    }


    public String getUserRank(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_RANK, Constant.EMPTY);
    }
    public String getUserLevel(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_LEVEL, Constant.EMPTY);
    }
    public String getUserDoj(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_DOJ, Constant.EMPTY);
    }
    public String getUserProPic(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_PRO_PIC, Constant.EMPTY);
    }
    public String getUserStatus(){
        SharedPreferences sp = tContext.getSharedPreferences(Constant.TSF_SHARED_PREFENCE, Context.MODE_PRIVATE);
       return sp.getString(Constant.USER_STATUS, Constant.EMPTY);
    }

}