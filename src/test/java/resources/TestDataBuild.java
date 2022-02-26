package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String language, String address) {
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName(name);
		
		
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		p.setTypes(types);
		
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		
		return p;
	}
	
public String deletePlacePayLoad(String placeid) {
		
		return "{\"place_id\":\""+placeid+"\"}";
	}

}
