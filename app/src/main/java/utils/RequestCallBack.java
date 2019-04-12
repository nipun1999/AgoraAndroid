package utils;

import android.app.Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RequestCallBack<T> implements Callback<T> {

    private Activity activity;

    public RequestCallBack(Activity activity) {
        this.activity = activity;
    }

    public abstract void success(Call<T> call, Response<T> response);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            success(call, response);
        } else {

        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
