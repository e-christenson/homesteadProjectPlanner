package hpp.project.planner;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import hpp.project.planner.com.zipCode.PlacesItem;
import hpp.project.planner.com.zipCode.ZipCode;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.zippopotam.us/us/53536");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

       ZipCode zipcode = mapper.readValue(response, ZipCode.class);

       PlacesItem placesItem = mapper.readValue(response,PlacesItem.class);
       // PlacesItem placesItem = mapper.readValue(response,PlacesItem.class);

        String expectedCountry = "United States";
        String expectedPlaceName = "Evansville";
       assertEquals(expectedCountry, zipcode.getCountry());
       assertEquals(expectedPlaceName,placesItem.getPlaceName() );
       // assertEquals(expectedPlaceName,placesItem.getPlaceName());
        //assertEquals("???", response);
    }
}
