package prod.esoteric.spawntest;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by John on 10/5/2015.
 */
public class SpawnActivityPage {

    WebDriver driver;
    protected TestCase test;

    public void setTestCase(TestCase testCase) {
        this.test = testCase;
    }

    @FindBy (id = "adder")
    public WebElement AdderButton;

    @FindBy (id = "customize")
    public WebElement CustomButton;

    @FindBy (id = "fragment_screen_slide_page")
    public WebElement SlideFragment;



    public SpawnActivityPage (WebDriver driver) {
        this.driver = driver;
    }



}
