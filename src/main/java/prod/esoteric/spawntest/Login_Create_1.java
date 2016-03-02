package prod.esoteric.spawntest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by John on 10/5/2015.
 */
public class Login_Create_1 extends AbstractHelper {

    @Test
    public void createChangeName() throws Exception {

        enterCredentials();

        createUserModify2Perms();

        List<WebElement> switchers = driver.findElements(By.id("switcher"));

        WebElement a = switchers.get(2);
        WebElement b = switchers.get(4);

        a.click();
        b.click();

        setNameOnly();

        String name = driver.findElement(By.id("userDetails")).getText();

        assert(name.contains("Happy  Hour"));
    }

    @Test
    public void createChangePassword() throws Exception {

        enterCredentials();

        createUserModify2Perms();

        List<WebElement> switchers = driver.findElements(By.id("switcher"));

        WebElement a = switchers.get(2);
        WebElement b = switchers.get(4);

        a.click();
        b.click();

        setPasswordOnly();

        String pword = driver.findElement(By.id("userDetails")).getText();

        assert(pword.contains("HappilyHourly"));
    }

    @Test
    public void createChangePermissions() throws Exception {

        enterCredentials();

        createUserModify2Perms();

        List<WebElement> switchers = driver.findElements(By.id("switcher"));

        WebElement homie = driver.findElement(By.id("homeButton"));

        WebElement a = switchers.get(2);
        WebElement b = switchers.get(3);
        WebElement c = switchers.get(4);

        a.click();
        b.click();

        homie.click();
        Thread.sleep(500);
        driver.findElement(By.id("btn_yes")).click();

        Thread.sleep(500);

        c.click();

        Thread.sleep(1500);

        homie.click();
        Thread.sleep(500);
        driver.findElement(By.id("btn_no")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("userDetails")).click();
        driver.findElement(By.id("userDetails")).click();

        driver.findElement(By.id("star")).click();
        Thread.sleep(5000);

        List<WebElement> switched = driver.findElements(By.id("switcher"));

        assert(!switched.get(2).isSelected());
        assert(!switched.get(3).isSelected());
        assert(!switched.get(4).isSelected());
        assert(switched.get(5).isSelected());


    }

    @Test
    public void createModifyPerms() throws Exception {

        enterCredentials();
        createUserModify2Perms();

        List<WebElement> switchers = driver.findElements(By.id("switcher"));

        for (WebElement e : switchers) {
            Thread.sleep(500);
            e.click();
        }

        clickHomeAfterChange();
    }



}
