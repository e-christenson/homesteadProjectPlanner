package hpp.project.planner.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hpp.project.planner.com.zipCode.ZipCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ZippopotamusDAO {
    private final Logger logger = LogManager.getLogger(this.getClass());

    Client client = ClientBuilder.newClient();

    //private String cityName;
    //private String stateName;
    //private int zipCode;


    public ZipCode GetCityState(String zipcode) throws JsonProcessingException {
        String apiUrl = "http://api.zippopotam.us/us/"+zipcode;
        WebTarget target =
                client.target(apiUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info("response string from API pre mapper: "+response);
        ObjectMapper mapper = new ObjectMapper();

        ZipCode zc = mapper.readValue(response, ZipCode.class);

        return zc;
    }





}
