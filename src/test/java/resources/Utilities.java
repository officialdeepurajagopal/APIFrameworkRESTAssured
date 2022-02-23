package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	public static RequestSpecification reqSpec;
	ResponseSpecification respSpec;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			
			reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURL")).addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json")
					    .addFilter(RequestLoggingFilter.logRequestTo(log))
					    .addFilter(ResponseLoggingFilter.logResponseTo(log))
						.setContentType(ContentType.JSON).build();
			return reqSpec;	
		}
	
		return reqSpec;	
	}
	
	public ResponseSpecification responseSpecification() {
		respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return respSpec;
	}
	
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream inpFile = new FileInputStream("/Users/deepurajagopal/eclipse-workspace/APIFramework/src/test/java/resources/global.properties");
		prop.load(inpFile);
		return prop.getProperty(key);
	}

}
