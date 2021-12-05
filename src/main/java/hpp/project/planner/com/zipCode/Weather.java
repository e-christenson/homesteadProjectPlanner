package hpp.project.planner.com.zipCode;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	@JsonProperty("init")
	private String init;

	@JsonProperty("product")
	private String product;

	@JsonProperty("dataseries")
	private List<DataseriesItem> dataseries;

	public String getInit(){
		return init;
	}

	public String getProduct(){
		return product;
	}

	public List<DataseriesItem> getDataseries(){
		return dataseries;
	}
}