package com.example.qr_readerexample;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anton on 12.05.2017.
 */

public class NetworkUtil
{
	public static void loginMe(Activity activity, String email, String pass)
	{
		MatchApi service = RetroClient.getApiService();

		Call<JsonObject> resultCall = service.loginUser(
				MultipartBody.Part.createFormData("email", email),
				MultipartBody.Part.createFormData("pass", pass));

		resultCall.enqueue(new Callback<JsonObject>() {
			@Override
			public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
				try {
					if (response.isSuccessful()) {
						String token = response.body().get("token").getAsString();
						Log.d("CloudS", token);
					} else {
						Log.e("CloudD", "error");
					}
				} catch (Exception e) {
					Log.e("CloudE", e.toString());
				}
			}

			@Override
			public void onFailure(Call<JsonObject> call, Throwable t) {
				Log.d("CloudE", t.toString());
			}
		});
	}

	public static void registerMe(Activity activity, String name, String email, String pass)
	{
		MatchApi service = RetroClient.getApiService();

		Call<JsonObject> resultCall = service.registrationUser(
				MultipartBody.Part.createFormData("name", name),
				MultipartBody.Part.createFormData("email", email),
				MultipartBody.Part.createFormData("pass", pass));

		resultCall.enqueue(new Callback<JsonObject>() {
			@Override
			public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
				try {
					if (response.isSuccessful()) {
						String token = response.body().get("token").getAsString();
						Log.d("CloudS", token);
					} else {
						Log.e("CloudD", "error");
					}
				} catch (Exception e) {
					Log.e("CloudE", e.toString());
				}
			}

			@Override
			public void onFailure(Call<JsonObject> call, Throwable t) {
				Log.d("CloudE", t.toString());
			}
		});
	}
}
