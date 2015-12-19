package com.nilsonmassarenti.test.docler.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nilsonmassarenti.test.view.App;

/**
 * This Class ReadProperties is responsible to provide the static informations
 * to the class
 * 
 * @author Nilson Massarenti
 * @version 0.1
 */
public class ReadProperties {
	/**
	 * This method is responsible to provide the properties
	 * 
	 * @return Properties
	 */
	public static Properties getProperties() {
		Properties properties = new Properties();
		try {
			InputStream in = App.class.getClassLoader()
					.getResourceAsStream("com/nilsonmassarenti/test/resource/pingclient.properties");
			properties.load(in);
			return properties;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
