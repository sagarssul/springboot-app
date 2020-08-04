package com.ust.pnp.arsenal.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ust.pnp.arsenal.config.Constants;
import com.ust.pnp.arsenal.exception.LooksServiceException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpUtil {

	public static <T> T connectToClientWithPost(String url, T requestBody, Class<T> type, String root)
			throws IOException, LooksServiceException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS).build();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = null;

		if (StringUtils.isNotBlank(root)) {
			ObjectWriter writer = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writer().withRootName(root);
			body = RequestBody.create(mediaType, writer.writeValueAsString(requestBody));
		} else {
			body = RequestBody.create(mediaType, mapper.writeValueAsString(requestBody));
		}
		
		Request request = new Request.Builder().url(url).method("POST", body)
				.addHeader("Content-Type", "application/json").build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new LooksServiceException(response.body().toString());
		}

		return (T) new ObjectMapper().readValue(response.body().string(), type);
	}

	public static <T> T connectToClientWithGet(String url, Class<T> type) throws IOException, LooksServiceException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS).build();

		Request request = new Request.Builder().url(url).method("GET", null)
				.addHeader("Content-Type", "application/json").build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new LooksServiceException(response.body().toString());
		}
		
		return (T) mapper.readValue(response.body().string(), type);

	}

}
