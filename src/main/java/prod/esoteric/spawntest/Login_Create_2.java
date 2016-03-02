package prod.esoteric.spawntest;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by John on 10/6/2015.
 */
public class Login_Create_2 extends SpawnrTesterMainLauncher {



    @Test
    public void loginCreateModify() throws Exception {

        driver.findElement(By.id("nameText")).sendKeys("$$$pwnr_");
        driver.findElement(By.id("keyText")).sendKeys("664230797057040");
        driver.findElement(By.id("secretText")).sendKeys("db928d925c9d700aec24d48115e29f94");

        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().window("NATIVE_APP");

        Thread.sleep(5000);

        driver.findElement(By.id("adder")).click();

        Thread.sleep(5500);
        driver.findElement(By.id("star")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("homeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("apps_Button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inAppLogoutButton")).click();
        Thread.sleep(5000);

    }}
