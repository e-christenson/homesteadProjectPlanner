package hpp.project.planner.com.zipCode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataseriesItem{

	@JsonProperty("date")
	private int date;

	@JsonProperty("weather")
	private String weather;

	@JsonProperty("wind10m_max")
	private int wind10mMax;

	@JsonProperty("temp2m")
	private Temp2m temp2m;

	public int getDate(){
		return date;
	}

	public String getWeather(){
		return weather;
	}

	public int getWind10mMax(){
		return wind10mMax;
	}

	public Temp2m getTemp2m(){
		return temp2m;
	}
}