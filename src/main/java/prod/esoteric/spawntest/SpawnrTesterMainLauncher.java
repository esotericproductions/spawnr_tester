package prod.esoteric.spawntest;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by John on 10/4/2015.
 */
public class SpawnrTesterMainLauncher {

    WebDriver     driver;
    WebDriverWait webDriverWait;

    protected SpawnActivityPage SPAWN_ACTIVITY;

    @Before
    public void setUp() throws Exception {
        driver = new SelendroidDriver(new SelendroidCapabilities("prod.esoteric.spawnr:3"));
        init();

        Thread.sleep(5000);
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    private void init() {
        pageFactorySetup();
    }

    private void pageFactorySetup() {
        SPAWN_ACTIVITY = PageFactory.initElements(driver, SpawnActivityPage.class);
    }
}
