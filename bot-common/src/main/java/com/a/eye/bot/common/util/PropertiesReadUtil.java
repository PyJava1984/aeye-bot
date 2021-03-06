package com.a.eye.bot.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReadUtil {

	public static Properties loadProperty(String property) {
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(property);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}