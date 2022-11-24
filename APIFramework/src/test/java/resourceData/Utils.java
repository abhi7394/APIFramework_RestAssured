package resourceData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException
	{
		if (req==null)
		{
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
		req= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON)
				 .addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
		}
		return req;
	} 
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("E:\\eclipse-workspace\\APIFramework\\src\\test\\java\\resourceData\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
