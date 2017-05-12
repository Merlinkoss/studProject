package com.example.qr_readerexample;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;

/**
 * Created by Anton on 12.05.2017.
 */

public interface MatchApi {

	/*
	Retrofit get annotation with our URL
	And our method that will return us the List of Contacts
	*/
	@Multipart
	@POST("/clien/")
	Call<JsonObject> registrationUser(@Part MultipartBody.Part name, @Part MultipartBody.Part email, @Part MultipartBody.Part pass);

	@Multipart
	@POST("")
	Call<JsonObject> loginUser(@Part MultipartBody.Part login, @Part MultipartBody.Part pass);

	@Multipart
	@POST("")
	Call<JsonObject> getLastTimeBackup(@Part MultipartBody.Part api, @Part MultipartBody.Part app, @Part MultipartBody.Part token);

	@Multipart
	@POST("")
	@Streaming
	Call<ResponseBody> downloadBackup(@Part MultipartBody.Part api, @Part MultipartBody.Part app, @Part MultipartBody.Part token);

}
