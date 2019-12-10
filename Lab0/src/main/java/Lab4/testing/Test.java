package Lab4.testing;

import Lab4.model.Act;
import Lab4.model.Actors;
import Lab4.model.ActorsRole;
import Lab4.model.Schedule;

import java.time.LocalDate;

public class Test {

    Actors actor1;
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
        actor1 = new Actors().new Builder()
                .setFirstName("Mariya")
                .setLastName("Zen")
                .setBirthday(LocalDate.now())
                .setSalary(5000d)
                .build();
    }

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
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

    @org.testng.annotations.Test(expectedExceptions = RuntimeException.class)
    public void builderTest7(){
        ActorsRole actorsRole = new ActorsRole().new Builder()
                .build();
    }

    @org.testng.annotations.Test(dependsOnMethods = "builderTest3", expectedExceptions = RuntimeException.class)
    public void builderTest8() {
        ActorsRole actorsRole = new ActorsRole().new Builder()
                .addActor(actor1)
                .setRole("Головна жіноча роль, Катерина")
                .build();
    }

    @org.testng.annotations.Test(dependsOnMethods = "builderTest3")
    public void builderTest9() {
        ActorsRole actorsRole = new ActorsRole().new Builder()
                .addActor(actor1)
                .setRole("Дяк, Петро")
                .build();
    }
}