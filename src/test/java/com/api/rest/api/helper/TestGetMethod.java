package com.api.rest.api.helper;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import com.api.rest.api.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGetMethod {
	
	@Test
	public void testGetPingAlive() {
		String url = "https://api.binance.com/api/v1/ping";
		RestResponse response = RestApiHelper.performGetRequest(url,null);
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals("{}", response.getResponseBody());
		System.out.println(response.getResponseBody());
	}
	
	@Test
	public void checkServerTime() {
		String url = "https://api.binance.com/api/v1/time";
		long previousTime = (int) (new Date().getTime()/1000);
		RestResponse response = RestApiHelper.performGetRequest(url,null);
		long currentTime = (int) (new Date().getTime()/1000); 
		System.out.println(response.getResponseBody());
		System.out.println(currentTime-previousTime+" seconds");
		long actualTime = currentTime- previousTime;
		assertTrue(actualTime<5);
		
	}
	

	
	
	

}
