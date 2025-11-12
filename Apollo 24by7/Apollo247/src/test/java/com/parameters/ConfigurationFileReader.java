package com.parameters;



	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

	public class ConfigurationFileReader {
		public static Properties pro;
		public static Properties fileReader() throws IOException {
				FileInputStream fis = new FileInputStream("src/test/resource/Properties/Data.properties");
				pro = new Properties();
				pro.load(fis);		
			return pro;
		}


	}

