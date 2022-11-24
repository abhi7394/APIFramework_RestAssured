package resourceData;

import java.util.ArrayList;
import java.util.List;

import pojo.location;
import pojo.pojo;

public class TestDataBuild {

	public pojo addplacedata(String name, String language, String address)
	{
		pojo m= new pojo();
		m.setAccuracy("50");
		m.setAddress(address);
		m.setLanguage(language);
		m.setName(name);
		m.setPhone_number("(+91) 983 893 3937");
		m.setWebsite("http://google.com");
		
		List<String> mylist= new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		m.setTypes(mylist);
		
		location l= new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		m.setLocation(l);
		
		return m;
	}
}
