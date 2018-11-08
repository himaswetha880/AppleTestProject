package com.apple.api_automation.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
	public static Properties loadproperties(String filename)
	{
		
		Properties property=new Properties();
		
		try {
			property.load(new FileInputStream(Constatnts.path+filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return property;
	}
	

}
