package com.peterford.groupeventorganizer.api.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Peter on 3/30/2018.
 */

public class ValidateUserRequest {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public ValidateUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
