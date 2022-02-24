package com.poc.graph.api;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GraphApiCallServiceImpl implements IGraphApiCallService {

	Logger logger = LoggerFactory.getLogger(GraphApiCallServiceImpl.class);

	@Override
	public void getEmailMessages(String token, String userId) {
		callApiUsingOkhttp3(token, userId);
		callApiUsingUnirest(token, userId);

	}

	private void callApiUsingOkhttp3(String token, String userId) {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder().url("https://graph.microsoft.com/v1.0/users/" + userId + "/messages")
				.method("GET", null).addHeader("Authorization", token).build();
		try {
			Response response = client.newCall(request).execute();
			logger.info(response.message());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void callApiUsingUnirest(String token, String userId) {
		Unirest.setTimeouts(0, 0);
		try {
			HttpResponse<JsonNode> response = Unirest
					.get("https://graph.microsoft.com/v1.0/users/" + userId + "/messages")
					.header("Authorization", token).asJson();

			// retrieve the parsed JSONObject from the response
			JSONObject myObj = response.getBody().getObject();
			logger.info(myObj.toString());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
}
