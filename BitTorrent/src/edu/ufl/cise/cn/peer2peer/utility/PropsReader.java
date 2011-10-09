package edu.ufl.cise.cn.peer2peer.utility;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;


/**
 * The Class PropsReader.
 */
public class PropsReader {
	
	/** The Constant store which will maintain property-key value from properties file. */
	private static final Hashtable<String, String> store = new Hashtable<String, String>();
	
	static{
		try {
			BufferedReader configFileReader =  new BufferedReader(new FileReader(Constants.CONFIGURATION_FILE));
			
			String line = configFileReader.readLine();
			
			// File is separated by space character
			
			while(line != null){
				String tokens[] = line.trim().split(" ");
				store.put(tokens[0].trim(), tokens[1].trim());
				 line = configFileReader.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception: "+e.getMessage());
			throw new ExceptionInInitializerError("Unable to load properties file");
		}
	}
	
	public static String getPropertyValue(String value){
		return store.get(value);
	}
}
