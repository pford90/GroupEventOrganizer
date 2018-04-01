package com.peterford.groupeventorganizer.api.endpoints;

import com.peterford.groupeventorganizer.api.request.ValidateUserRequest;
import com.peterford.groupeventorganizer.api.responses.CommonResponse;
import com.peterford.groupeventorganizer.api.responses.UserResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserEndpoints {

    @Headers("api_key: 66B68F298F0D2C8C9DB25D11CDDD602F79287343EF2EBB56AF6EC7ECE3114A3C")
    @POST("login")
    Call<UserResponse> validateUser(@Header("Authorization")String credentials);



    Retrofit retroFit = new Retrofit.Builder()
                            .baseUrl("http://api.acm.org/dl/v1/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient.Builder()
                                    .connectTimeout(1, TimeUnit.MINUTES)
                                    .readTimeout(30, TimeUnit.SECONDS)
                                    .writeTimeout(15, TimeUnit.SECONDS)
                                    .build())
                            .build();

    UserEndpoints userEndpoints = retroFit.create(UserEndpoints.class);
}
