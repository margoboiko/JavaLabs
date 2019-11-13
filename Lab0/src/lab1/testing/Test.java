package lab1.testing;
import lab1.Act;
import lab1.Actors;
import lab1.ActorsRole;
import lab1.Schedule;


import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void builderTest() {
        Act act = new Act.Builder()
                .setName("Вечори на хуторі близь Диканьки")
                .build();
    }

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void builderTest2() {
        Actors actors = new Actors().new Builder()
                .setSalary(2000d)
                .build();
    }

    @org.testng.annotations.Test
    public void builderTest3() {
        Actors actors = new Actors().new Builder()
                .setSalary(5000d)
                .build();
    }

    @org.testng.annotations.Test
    public void builderTest4() {
        Actors actors = new Actors().new Builder()
                .setBirthday(LocalDate.of(1970, 2, 5))
                .build();
    }

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void builderTest5() {
        Schedule schedule = new Schedule().new Builder()
                .setPrice(500.)
                .build();
    }

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void builderTest6(){
        Schedule schedule = new Schedule().new Builder()
                .setPrice(500.)
                .build();
    }

    @org.testng.annotations.Test
    public void builderTest7(){
        ActorsRole actorsRole = new ActorsRole().new Builder()
                .setActor(null)
                .build();
    }

    @org.testng.annotations.Test
    public void builderTest8() {
        ActorsRole actorsRole = new ActorsRole().new Builder()
                .setRole("Головна жіноча роль, Катерина")
                .build();
    }
}