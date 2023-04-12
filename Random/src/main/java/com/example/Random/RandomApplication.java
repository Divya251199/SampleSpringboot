package com.example.Random;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RandomApplication {

	public static void main(String[] args) throws Exception {

		URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode == 200 ) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;

			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}
			in.close();
			JSONObject randomJokes = (JSONObject) new JSONObject(jsonResponseData.toString());
			System.out.println(randomJokes.get("value"));
		} else {
			System.out.println("This is not a Valid URL" + responseCode);
		}
	}

}
