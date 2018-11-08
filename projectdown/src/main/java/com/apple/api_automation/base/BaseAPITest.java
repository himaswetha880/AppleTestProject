package com.apple.api_automation.base;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.apple.api_automation.helper.ConfigUtils;

public class BaseAPITest {
	
protected String endpoint;
@BeforeSuite
public void beforeSuite()
{

	Properties property=ConfigUtils.loadproperties("config.properties");
	endpoint=property.getProperty(("TestURL"));
	
}


}
