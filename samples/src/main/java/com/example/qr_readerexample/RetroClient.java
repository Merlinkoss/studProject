package com.example.qr_readerexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anton on 12.05.2017.
 */
public class RetroClient {

	/**
	 * Upload URL of your folder with php file name...
	 * You will find this file in php_upload folder in this project
	 * You can copy that folder and paste in your htdocs folder...
	 */
	private static final String ROOT_URL = "http:da.ru";


	public RetroClient() {

	}

	/**
	 * Get Retro Client
	 *
	 * @return JSON Object
	 */
	private static Retrofit getRetroClient() {
		return new Retrofit.Builder()
				.baseUrl(ROOT_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public static MatchApi getApiService() {
		return getRetroClient().create(MatchApi.class);
	}
}
