package com.apple.api_automation.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apple.api_automation.base.BaseAPITest;
import com.apple.api_automation.base.BaseApi;
import com.apple.api_automation.helper.ApiResponse;

public class StoreDown_ApiTesting extends BaseAPITest {
	static BaseApi api;
	private static StoreDown_ApiTesting getinstance;
	private StoreDown_ApiTesting() {
		
	}
	public static JSONObject object=null;
	public static ApiResponse response=null;
	public static StoreDown_ApiTesting instance()
	{
		if (getinstance==null){
			 getinstance=new StoreDown_ApiTesting();
			 return getinstance;
		}
		else return getinstance;
	}
	
	public static String response()
	{
		
		if(response==null){
		response = api.get("/status?authentication=false");
		System.out.println("response created");
		return response.getPayload();
		}
		
		return response.getPayload();
	}
	
	public static JSONObject object()
	{
		
				if(object==null){
		object = new JSONObject(StoreDown_ApiTesting.response());
		System.out.println("object created");
		return object;
		}
		return object;
	}
	
	

	@BeforeClass
	private void beforeClass() {
		api = new BaseApi(endpoint);

	}

	@Test
	public void getStatusTest() {
		ApiResponse response = api.get("/status?authentication=false");
		System.out.println(response.getStatuscode());
		assertEquals(response.getStatuscode(), 200);
		System.out.println(response.getStatusMessage());
		assertTrue(response.getStatusMessage().contains("HTTP/1.1 200 OK"));
	

	}

	@DataProvider(name="test")

	public static Iterator<Object[]> locales() throws InterruptedException {

	    List<Object[]> data = new ArrayList<>();
	    JSONArray keys=StoreDown_ApiTesting.object().names();
	    for(int i=0;i<keys.length();i++)
	    {
	    	 data.add(new String[]{keys.get(i).toString()});
	    	 Thread.sleep(200);
	    }
	    return data.iterator();

	}

	

	@Test(dataProvider="test")
	public void country_status_y(String name) 
	{   JSONObject obj=null;
		obj=StoreDown_ApiTesting.object().getJSONObject(name);
		 if("y".equals(obj.get("status")))
{
			 System.out.println("*******Failed country name*******");
			 System.out.println("country name--"+obj.get("name"));
			 
		 }
		Assert.assertEquals(obj.get("status"),"n");
	
}
	
	
}		

