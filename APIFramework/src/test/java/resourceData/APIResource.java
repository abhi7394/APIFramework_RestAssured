package resourceData;

public enum APIResource {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	
	APIResource(String resource)
	{
		this.resource=resource;
	}

	public String getresource()
	{
		return resource;
	}
}
