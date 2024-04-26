package com.dit.chatapp.utils;

import java.util.ResourceBundle;
//This is made to read the config file only 
public class ConfigReader {
	ConfigReader() {
		// TODO Auto-generated constructor stub
	}
//	ResourceBundle is used to get the config.properties file access
	private static ResourceBundle rb= ResourceBundle.getBundle("config");
	public static String getValue(String key) {
		return rb.getString(key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
