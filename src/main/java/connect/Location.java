package connect;

public class Location {
	private int locationID;
	private int eventID;
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private int cityID;
	private String country;
	private String longitude;
	private String latitude;
	
	
	public Location() {
		super();
	}
	public Location(int locationID, int eventID, int cityID, String country, String longitude, String latitude) {
		super();
		this.locationID = locationID;
		this.eventID = eventID;
		this.cityID = cityID;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID() {
		if(city.equals("BUCURESTI")) {
			this.cityID = 1;
		}else if(city.equals("BRASOV")) {
			this.cityID = 2;
		} else if(city.equals("CLUJ")) {
			this.cityID = 3;
		}else if(city.equals("IASI")) {
			this.cityID = 4;
		}else if(city.equals("TIMISOARA")) {
			this.cityID = 5;
		}
		
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	} 
	
	
}
