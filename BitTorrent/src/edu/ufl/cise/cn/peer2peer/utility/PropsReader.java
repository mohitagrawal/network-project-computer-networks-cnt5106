package edu.ufl.cise.cn.peer2peer.utility;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import com.test.ProcessStarter;



// TODO: Auto-generated Javadoc
/**
 * The Class PropsReader.
 *
 * @author sagarg
 */
public class PropsReader {
	
	/** The Constant store which will maintain property-key value from properties file. */
	private static final Hashtable<String, String> store = new Hashtable<String, String>();

	/*
	 * 
	 * It parses Configuration file when this class is loaded.
	 * 
	 * */
	static{
		try {
//			BufferedReader configFileReader =  new BufferedReader(new InputStreamReader(PropsReader.class.getResourceAsStream(Constants.CONFIGURATION_FILE) ));
			BufferedReader configFileReader =  new BufferedReader(new InputStreamReader(new FileInputStream(Constants.CONFIGURATION_FILE)));
			
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
	
	/**
	 * Gets the property value.
	 *
	 * @param value the value
	 * @return the property value
	 */
	public static String getPropertyValue(String value){
		return store.get(value);
	}
}
