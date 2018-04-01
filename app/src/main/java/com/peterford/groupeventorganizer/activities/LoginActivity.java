package com.peterford.groupeventorganizer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.api.endpoints.UserEndpoints;
import com.peterford.groupeventorganizer.api.request.ValidateUserRequest;
import com.peterford.groupeventorganizer.api.responses.CommonResponse;
import com.peterford.groupeventorganizer.api.responses.UserResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.input_email) EditText mEmailInput;
    @BindView(R.id.input_password) EditText mPasswordInput;
    @BindView(R.id.btn_login) Button mLoginButton;
    @BindView(R.id.login_progressbar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private void loginSuccessful(UserResponse user) {
        String email = mEmailInput.getText().toString();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    @OnClick(R.id.btn_login)
    public void logon(View view) {
/*
        if( !validateInput() ) {
            onLoginFailed();
            return;
        }
*/
        mLoginButton.setEnabled(false);
        mProgressBar.setVisibility(View.VISIBLE);
        String email = mEmailInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        String base64 = Credentials.basic(email, password);

        Call<UserResponse> call = UserEndpoints.userEndpoints.validateUser(base64);
        Log.v(TAG, base64);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.v(TAG, response.message());
                Log.v(TAG, response.toString());
                Log.v(TAG, response.code() + "");
                if( response.code() == 200) {
                    loginSuccessful(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        mLoginButton.setEnabled(true);
        mProgressBar.setVisibility(View.GONE);
    }

    private void onLoginFailed() {
        Toast.makeText(this, "INSIDE LOGIN FAILED", Toast.LENGTH_SHORT).show();
    }

    private boolean validateInput() {
        String email = mEmailInput.getText().toString();
        String password = mPasswordInput.getText().toString();
        boolean valid = true;

        if( email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches() ) {
            Log.v(TAG, "INSIDE EMAIL ERROR");
            mEmailInput.setError("enter a valid email address");
            valid = false;
        } else {
            mEmailInput.setError(null);
        }

        if( password.isEmpty() || password.length() < 4 || password.length() > 12 )  {
            Log.v(TAG, "INSIDE PASSWORD ERROR");
            mPasswordInput.setError("Password has to be more than 4 and password has to be less than 12");
            valid = false;
        } else {
            mPasswordInput.setError(null);
        }

        return valid;
    }

}
