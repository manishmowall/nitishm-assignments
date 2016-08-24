import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium2Example  {
    public static void main(String[] args) {



        try {
            System.setProperty("webdriver.chrome.driver","/home/webonise/Downloads/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver,10);
            driver.get("https://www.tripadvisor.in");


            WebElement flightSpan = driver.findElement(By.id("rdoFlights"));
            flightSpan.click();

            WebElement inputFlightFrom = driver.findElement(By.id("metaFlightFrom"));
            inputFlightFrom.clear();
            inputFlightFrom.sendKeys("pune");
            Thread.sleep(2000);

            inputFlightFrom.sendKeys(Keys.ENTER);

           //Thread.sleep(2000);
            WebElement inputFlightTo = driver.findElement(By.id("metaFlightTo"));
            inputFlightTo.clear();
            inputFlightTo.sendKeys("delhi");
            Thread.sleep(2000);
            inputFlightTo.sendKeys(Keys.ENTER);




            WebElement inputFLightCheckIn = driver.findElement(By.id("checkIn"));
            inputFLightCheckIn.clear();
            inputFLightCheckIn.sendKeys("7/8/2016");
            inputFLightCheckIn.sendKeys(Keys.ENTER);


            //WebElement inputFLightCheckOut = driver.findElement(By.id("checkOut"));
          //  inputFLightCheckOut.clear();

           // inputFLightCheckOut.sendKeys("14/8/2016");
           // inputFLightCheckOut.sendKeys(Keys.ENTER);


        }catch (NoSuchElementException ex){
            System.out.println(ex.getStackTrace());
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }

    }//main



}