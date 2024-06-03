package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json"), 
				StandardCharsets.UTF_8);
		
		//String to HashMap Jackson Databind
		//The ObjectMapper class has a method called readValue, this will read the value from the string we created from our json, this string it will 
		//convert into whatever you want, in our case we want to create a List, this contains an array with two indexes which will be HashMaps
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;   //This "data" that we return now contains a List of HashMaps
		
		
		
		
		
		}
		
	}


