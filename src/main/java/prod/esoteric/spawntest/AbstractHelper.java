package prod.esoteric.spawntest;

import com.android.annotations.NonNull;
import com.google.common.base.Function;

import io.selendroid.client.SelendroidKeys;
import io.selendroid.server.common.exceptions.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by John on 10/6/2015.
 */
public class AbstractHelper extends SpawnrTesterMainLauncher {

    public void enterCredentials() throws Exception {

        driver.findElement(By.id("nameText")).sendKeys("$$$pwnr_");
        driver.findElement(By.id("keyText")).sendKeys("664230797057040");
        driver.findElement(By.id("secretText")).sendKeys("db928d925c9d700aec24d48115e29f94");

        new Actions(driver).sendKeys(SelendroidKeys.ENTER).perform();
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().window("NATIVE_APP");

        Thread.sleep(5500);
    }

    public void createUserModify2Perms() throws Exception {

        driver.findElement(By.id("adder")).click();

        Thread.sleep(15500);
        driver.findElement(By.id("star")).click();
        Thread.sleep(5000);
    }

    public void clickHomeAfterChange() throws Exception {

        driver.findElement(By.id("homeButton")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btn_no")).click();
    }

    public void setNameOnly()throws Exception {

        driver.findElement(By.id("namebutton")).click();
        Thread.sleep(500);
        driver.findElement(By.id("name_button")).click();
        Thread.sleep(500);
        driver.findElement(By.id("namerText")).sendKeys("Happy Hour");
        driver.findElement((By.id("setMyName"))).click();
        Thread.sleep(10000);
    }

    public void setPasswordOnly()throws Exception {

        driver.findElement(By.id("namebutton")).click();
        Thread.sleep(500);
        driver.findElement(By.id("password_button")).click();
        driver.findElement(By.id("passerText")).sendKeys("HappilyHourly");
        driver.findElement((By.id("setMyPassword"))).click();
        Thread.sleep(10000);
    }


    public void setNamePassword()throws Exception {

        driver.findElement(By.id("namebutton")).click();
        Thread.sleep(500);
        driver.findElement(By.id("name_button")).click();
        driver.findElement(By.id("nameText")).sendKeys("Happy Hour");
        driver.findElement(By.id("passerText")).sendKeys("HappilyHourly");
        driver.findElement((By.id("setMyName"))).click();
        Thread.sleep(10000);
    }

    public void waitForElementClickable(final int timeout, final String locType, final String locator, final WebElement webEl) {

        new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(new Function<WebDriver, Boolean>() {

                    @NonNull
                    @Override
                    public Boolean apply(WebDriver driver) {
                        WebElement element = null;

                        if(locType != null && locator != null) {

                            if(locType.equalsIgnoreCase("id")) {
                                element = driver.findElement(By.id(locator));
                            } else if (locType.equalsIgnoreCase("xpath")) {
                                element = driver.findElement(By.xpath(locator));
                            }
                        } else {
                            element = webEl;
                            WebDriverWait dWait = new WebDriverWait(driver, timeout);
                            dWait.until(ExpectedConditions.elementToBeClickable(webEl));
                        }

                        if (element != null) {
                            Actions actions = new Actions(driver);
                            actions.moveToElement(element).build().perform();
                            System.out.println("Element in focus: " + element);
                        }
                        return element != null && element.isDisplayed();
                    }
                });
    }


    public void waitForElementVisible(final int timeout, final String locType, final String locator, final WebElement webEl) {

        new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(new Function<WebDriver, Boolean>() {

                    @NonNull
                    @Override
                    public Boolean apply(WebDriver driver) {
                        WebElement element = null;

                        if(locType != null && locator != null) {

                            if(locType.equalsIgnoreCase("id")) {
                                element = driver.findElement(By.id(locator));
                            } else if (locType.equalsIgnoreCase("xpath")) {
                                element = driver.findElement(By.xpath(locator));
                            }
                        } else {
                            element = webEl;
                            WebDriverWait dWait = new WebDriverWait(driver, timeout);
                            dWait.until(ExpectedConditions.visibilityOf(webEl));
                        }

                        if (element != null) {
                            Actions actions = new Actions(driver);
                            actions.moveToElement(element).build().perform();
                            System.out.println("Element in focus: " + element);
                        }
                        return element != null && element.isDisplayed();
                    }
                });
    }


    public void implicitWait( int timeToWait ) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitForVisibilityAndClickId (int timeToWait, String identity) {
        webDriverWait = new WebDriverWait(driver, timeToWait);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(identity)));

        driver.findElement(By.id(identity)).click();
    }

    public void waitForInvisibilityAndClickId (int timeToWait, String identity) {
        webDriverWait = new WebDriverWait(driver, timeToWait);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(identity)));

        driver.findElement(By.id(identity)).click();
    }



}
