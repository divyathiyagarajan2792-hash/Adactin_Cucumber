package com.adactincucumber.configreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties p;
	
	public ConfigReader() throws IOException {

	File f=new File("src/test/resources/config/config.properties");
	FileInputStream fis=new FileInputStream(f);
	p=new Properties();
	p.load(fis);

    fis.close();
    
    
}

	public String getProperty(String key) {
		return p.getProperty(key);
	}
}
	

