package utils;

import android.content.Context;
import android.content.SharedPreferences;

public class sessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    Context ctx;
    private static final String PREF_NAME = "Agora";
    private String LOGIN_STATUS = "loginStatus";

    public sessionManager(Context context){
        this.ctx = context;
        sharedPreferences = ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setLoginSatus(boolean status){
        editor.putBoolean(LOGIN_STATUS,status);
        editor.commit();
    }

    public boolean getLoginStatus(){
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

}
