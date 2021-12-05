package hpp.project.planner.com.zipCode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temp2m{

	@JsonProperty("min")
	private int min;

	@JsonProperty("max")
	private int max;

	public int getMin(){
		return min;
	}

	public int getMax(){
		return max;
	}
}