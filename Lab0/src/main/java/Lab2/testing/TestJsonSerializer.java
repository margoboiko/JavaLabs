package Lab2.testing;

import Lab2.exception.ConvertException;
import Lab2.model.Act;
import Lab2.model.Actors;
import Lab2.model.ActorsRole;
import Lab2.service.JsonSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestJsonSerializer {

    private JsonSerializer actorsJsonSerializer;
    Actors actors;

    @BeforeTest
    public void beforeTest() {
        actorsJsonSerializer = new JsonSerializer(Actors.class);
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
        String expected = "{\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"birthday\":\"2019-11-21\",\"salary\":4500.0}";
        String actual = actorsJsonSerializer.serializeToString(actors);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeFromStringTest() throws IOException {
        String s = "{\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"birthday\":\"2019-11-21\",\"salary\":4500.0}";
        Assert.assertEquals( actorsJsonSerializer.deserializeFromString(s), actors);
    }

    @Test(dataProvider = "fileProvider")
    public void fromFileTest(File file) throws ConvertException {
        Assert.assertEquals(actorsJsonSerializer.fromFile(file), actors);
    }

    @DataProvider
    public Object[][] fileProvider() throws ConvertException {
        File f = new File("result.json");
        actorsJsonSerializer.toFile(actors, f);
        return new Object[][]{{f}};
    }

}