package resources;

public enum APIResources {
	// class that can be used to store constants or methods
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	UpdatePlaceAPI("maps/api/place/update/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	// create a constructor
	
	private String resource;
	
	APIResources(String resource){
		
		this.resource=resource;
		
	}
	
	public String getResourse() {
		return resource;
	}

}
