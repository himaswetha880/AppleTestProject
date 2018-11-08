package com.apple.api_automation.base;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.apple.api_automation.helper.ConfigUtils;
import com.apple.api_automation.helper.ApiResponse;

public class BaseApi {
	
	private String url;
	ApiResponse apiResponse;
	HttpClient httpClient;
	public BaseApi(String url)
	{
		 this.url=url;
		 httpClient=HttpClientBuilder.create().build();
		 setAuthenntication();
	}
	public void setAuthenntication()
	{
				Properties property=ConfigUtils.loadproperties("config.properties");
		}	
	public ApiResponse get(String resouce)
	{
		HttpGet get =new  HttpGet(url+resouce);
		apiResponse =new ApiResponse();		
		try {			
		HttpResponse response = httpClient.execute(get);
			apiResponse.setStatuscode(response.getStatusLine().getStatusCode());
	     	apiResponse.setStatusMessage((response.getStatusLine().toString()));
		    apiResponse.setPayload((IOUtils.toString(response.getEntity().getContent())));
		} catch (ClientProtocolException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
		return apiResponse;				
	}
	
	
		 
	}


