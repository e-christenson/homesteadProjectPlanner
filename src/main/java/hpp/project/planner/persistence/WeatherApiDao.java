package hpp.project.planner.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hpp.project.planner.com.zipCode.Weather;
import hpp.project.planner.com.zipCode.ZipCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherApiDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    //private String zipCode;

    private String LongLatt;


    public Weather getWeather(String longLatt) throws JsonProcessingException {
        String apiUrl = "https://www.7timer.info/bin/civillight.php?"+longLatt+"&ac=0&unit=british&output=json&tzshift=0";
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(apiUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        //logger.info("response string from 7timer weather API pre mapper: "+response);
        ObjectMapper mapper = new ObjectMapper();

        Weather weather = mapper.readValue(response, Weather.class);
        return weather;

        //String tempNow = String.valueOf(weather.getDataseries().get(0).getTemp2m());
        //ZipCode zipcode = mapper.readValue(response, ZipCode.class);
        //cityName = zipcode.getPlaces().get(0).getPlaceName();
        //LongLatt = ("lon="+zipcode.getPlaces().get(0).getLongitude()+"&lat="+zipcode.getPlaces().get(0).getLatitude());

    }



    }






