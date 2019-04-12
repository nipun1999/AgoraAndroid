package retrofit;

import org.json.JSONObject;

import java.util.Map;

import model.loginModel;
import model.signUpModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    //initiation of all api calls

    @Headers("Content-Type: application/json")
    @POST("api/v1/auth/signup")
    Call<signUpModel> userSignUp(@Body String body);

    @Headers("Content-Type: application/json")
    @POST("api/v1/auth/login")
    Call<loginModel> userLogin(@Body String body);


}
