package hpp.project.planner.persistence;

import hpp.project.planner.com.zipCode.PlacesItem;
import hpp.project.planner.com.zipCode.ZipCode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZippopotamusDaoTest {
    @Test
    public void testZipApi() throws Exception {
        ZippopotamusDAO zippoDAO = new ZippopotamusDAO();

        ZipCode zc = zippoDAO.GetCityState("53589");

        String cityFromApi = zc.getPlaces().get(0).getPlaceName();


        String state = zc.getPlaces().get(0).getState();

        assertEquals("Stoughton",cityFromApi);
        assertEquals("Wisconsin", state);


        //assertEquals("???", response);
    }


}
