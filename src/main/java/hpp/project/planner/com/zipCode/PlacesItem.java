package hpp.project.planner.com.zipCode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlacesItem{

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("state")
	private String state;

	@JsonProperty("state abbreviation")
	private String stateAbbreviation;

	@JsonProperty("place name")
	private String placeName;

	@JsonProperty("longitude")
	private String longitude;

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setStateAbbreviation(String stateAbbreviation){
		this.stateAbbreviation = stateAbbreviation;
	}

	public String getStateAbbreviation(){
		return stateAbbreviation;
	}

	public void setPlaceName(String placeName){
		this.placeName = placeName;
	}

	public String getPlaceName(){
		return placeName;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"erik---PlacesItem{" +
			"latitude = '" + latitude + '\'' + 
			",state = '" + state + '\'' + 
			",state abbreviation = '" + stateAbbreviation + '\'' + 
			",place name = '" + placeName + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}