package prod.esoteric.spawntest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by John on 10/6/2015.
 */
public class SpawnrCases {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({ Login_Create_1.class, Login_Create_2.class })
    public class loginCreateSuite {

    }




}
