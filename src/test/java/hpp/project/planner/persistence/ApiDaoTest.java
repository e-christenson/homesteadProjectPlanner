package hpp.project.planner.persistence;

import hpp.project.planner.com.zipCode.PlacesItem;
import hpp.project.planner.com.zipCode.Weather;
import hpp.project.planner.com.zipCode.ZipCode;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiDaoTest {
    @Test
    public void testZipApi() throws Exception {
        ZipApiDao zDAO = new ZipApiDao();

        List<PlacesItem> pi = zDAO.getCityState("53589");



        String cityFromApi = pi.get(0).getPlaceName();
        //String state = zc.getPlaces().get(0).getState();
        String longLatt = zDAO.getLongLatt();

       // assertEquals("Stoughton",cityFromApi);
       // assertEquals("Wisconsin", state);


        //assertEquals("???", response);
    }

    @Test
    public void testWeatherApi() throws Exception {
        WeatherApiDao wDao = new WeatherApiDao();
        Weather weather = wDao.getWeather("lon=-89.224&lat=42.929");

        //assertEquals("Stoughton",weather.toString());
        assertEquals("cloudy",weather.getDataseries().get(0).getWeather());
        assertEquals(48,weather.getDataseries().get(0).getTemp2m().getMax());
        assertEquals(37,weather.getDataseries().get(0).getTemp2m().getMin());
      //  assertEquals("Wisconsin", state);


        //assertEquals("???", response);
    }



}
