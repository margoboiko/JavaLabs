package Lab2.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import Lab2.model.Actors;
import Lab2.service.XmlSerializer;
import Lab2.exception.ConvertException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestXmlSerializer {
    //private XmlSerializer<Actors> actorsXmlSerializerXmlSerializer;
    private Actors actors;

    private XmlSerializer<Actors> actorsXmlSerializer;

    @BeforeTest
    public void beforeTest() {
       actorsXmlSerializer = new XmlSerializer<>(Actors.class);
        ArrayList<Actors> arrayActors = new ArrayList<>();
        actors = new Actors().new Builder()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setBirthday(LocalDate.parse("2019-11-21"))
                .setSalary(4500.0)
                .build();
        arrayActors.add(actors);

    }

    @Test
    public void serializeToStringTest() throws JsonProcessingException {
        String s = "<Actors xmlns=\"\"><firstName>FirstName</firstName><lastName>LastName</lastName><birthday>2019-11-21</birthday><salary>4500.0</salary></Actors>";
        Assert.assertEquals( s , actorsXmlSerializer.serializeToString(actors));
    }

    @Test
    public void deserializeFromStringTest() throws IOException {
        String s = "<Actors xmlns=\"\"><firstName>FirstName</firstName><lastName>LastName</lastName><birthday>2019-11-21</birthday><salary>4500.0</salary></Actors>\n";
        Assert.assertEquals(actors, actorsXmlSerializer.deserializeFromString(s));
    }

    @Test(dataProvider = "fileProvider")
    public void fromFileTest(File file) throws ConvertException {
        Assert.assertEquals(actorsXmlSerializer.fromFile(file), actors);
    }

    @DataProvider
    public Object[][] fileProvider() throws ConvertException {
        File f = new File("result.json");
        actorsXmlSerializer.toFile(actors, f);
        return new Object[][]{{f}};
    }
}