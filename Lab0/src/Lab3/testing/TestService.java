package Lab3.testing;

import Lab3.model.Act;
import Lab3.model.Actors;
import Lab3.model.ActorsRole;
import Lab3.service.ActService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestService {

        private List<ActorsRole> roleList;
        ActorsRole role1, role2, role3, role4;
        ActService service;
        Actors actor1, actor2, actor3;
        @BeforeTest
        public void createActors() {
            actor1 = new Actors().new Builder()
                    .setFirstName("Симоненко")
                    .setLastName("Катерина")
                    .setBirthday(LocalDate.parse("1985-10-25"))
                    .setSalary(4500.0)
                    .build();

            actor2 = new Actors().new Builder()
                    .setFirstName("Кириленко")
                    .setLastName("Віктор")
                    .setBirthday(LocalDate.parse("1963-05-23"))
                    .setSalary(6000.0)
                    .build();

            actor3 = new Actors().new Builder()
                    .setFirstName("Мойсеєнко")
                    .setLastName("Єлизавета")
                    .setBirthday(LocalDate.parse("2000-08-23"))
                    .setSalary(8000.0)
                    .build();

            role1 = new ActorsRole().new Builder()
                    .addActor(actor1)
                    .setRole("Катерина")
                    .build();

            role2 = new ActorsRole().new Builder()
                    .addActor(actor1)
                    .setRole("Дерево")
                    .build();

            role3 = new ActorsRole().new Builder()
                    .addActor(actor2)
                    .setRole("Іван")
                    .build();

            role4 = new ActorsRole().new Builder()
                    .addActor(actor3)
                    .setRole("Дерево")
                    .build();

            Act act1 = new Act(). new Builder()
                    .setName("Катерина")
                    .setGenre("Драма")
                    .addRole(role1)
                    .addRole(role2)
                    .addRole(role3)
                    .addRole(role4)
                    .build();
            service = new ActService(act1);
        }

        @Test
        public void SortActByRole(){
            List<ActorsRole> roles = new ArrayList<>();
            roles.add(role1);
            roles.add(role2);
            roles.add(role3);
            roles.add(role4);
            roles.sort(Comparator.comparing(ActorsRole::getRole));
            Assert.assertEquals(service.sortActByRole(), roles);

        }

        @Test
        public void GetAvgSalaryTest() {
            Double sum = role1.getActor().getSalary() + role2.getActor().getSalary()
                    + role3.getActor().getSalary() + role4.getActor().getSalary();
            Assert.assertEquals(service.getAvgSalary(), sum/4);
        }

        @Test
        public void GetListActorsTest() {
            List<Actors> actors = new ArrayList<>();
            actors.add(actor1);
            actors.add(actor3);

            Assert.assertEquals(service.getListActors("Дерево"), actors);
        }

}
