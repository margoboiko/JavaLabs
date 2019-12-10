package Lab2.testing;

import Lab2.exception.ConvertException;
import Lab2.model.Actors;
import Lab2.service.TextSerializer;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestTextSerializer {
    private Actors actors;

    @BeforeTest
    public void createActors() {
        actors = new Actors().new Builder()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setBirthday(LocalDate.parse("1985-10-25"))
                .setSalary(4500.0)
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "FirstName---LastName---1985-10-25---4500.0";
        String actorsstr = new TextSerializer().serializeToString(actors);
        Assert.assertEquals(expected, actorsstr);
    }

    @Test
    public void deserializeFromStringTest() throws ConvertException {
        String string = "FirstName---LastName---1985-10-25---4500.0";
        Assert.assertEquals(actors, new TextSerializer().deserializeFromString(string));
    }
}