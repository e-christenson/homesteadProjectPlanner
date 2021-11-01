package hpp.project.planner.persistence;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipApiDaoTest {
    @Test
    public void testZipApi() throws Exception {


        ZipApiDao zipApiDao = new ZipApiDao("53589");
        String cityFromApi = zipApiDao.getLocationFromZip();
        String longLatt = zipApiDao.getLongLatt();

        assertEquals("Stoughton",cityFromApi);
        assertEquals("-89.224 , 42.929",longLatt);

        //assertEquals("???", response);
    }


}
