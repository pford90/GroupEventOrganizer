package com.peterford.groupeventorganizer.api.responses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserResponse implements Parcelable{

    @SerializedName("user_statu")
    private String status;

    @SerializedName("user_email")
    private String email;

    @SerializedName("user_firstname")
    private String firstName;

    @SerializedName("user_lastname")
    private String lastName;

    @SerializedName("auth_token")
    private String authToken;

    private UserResponse(Parcel parcel) {
        status = parcel.readString();
        email = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        authToken = parcel.readString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(status);
        parcel.writeString(email);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(authToken);
    }

    public static Parcelable.Creator<UserResponse> CREATOR = new Parcelable.Creator<UserResponse>() {

        @Override
        public UserResponse createFromParcel(Parcel parcel) {
            return new UserResponse(parcel);
        }

        @Override
        public UserResponse[] newArray(int i) {
            return new UserResponse[i];
        }
    };
}
