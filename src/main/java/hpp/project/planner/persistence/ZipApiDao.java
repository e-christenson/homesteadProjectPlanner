package hpp.project.planner.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hpp.project.planner.com.zipCode.PlacesItem;
import hpp.project.planner.com.zipCode.ZipCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ZipApiDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    //private String zipCode;
    private String cityName;
    private String LongLatt;


    public ZipApiDao(String zipCode) throws JsonProcessingException {
        String apiUrl = "http://api.zippopotam.us/us/"+zipCode;
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(apiUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info("response string from API pre mapper: "+response);
        ObjectMapper mapper = new ObjectMapper();

        ZipCode zipcode = mapper.readValue(response, ZipCode.class);
        cityName = zipcode.getPlaces().get(0).getPlaceName();
        LongLatt = (zipcode.getPlaces().get(0).getLongitude()+" , "+zipcode.getPlaces().get(0).getLatitude());

    }

    public String getLocationFromZip() {

    return cityName;

    }

    public String getLongLatt() {

                return LongLatt;

    }



}
