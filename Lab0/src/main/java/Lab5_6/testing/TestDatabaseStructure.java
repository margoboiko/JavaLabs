
package Lab5_6.testing;

import Lab5_6.database.DatabaseStructure;
import org.testng.annotations.Test;


public class TestDatabaseStructure {

    @Test
    public void createTablesTest() throws Exception {
        DatabaseStructure.createTables();
    }

    @Test
    public void dropTablesTest() throws Exception {
        DatabaseStructure.dropTables();
    }

  }