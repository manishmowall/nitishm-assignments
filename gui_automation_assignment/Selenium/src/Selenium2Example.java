import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.List;


public class Selenium2Example  {
    WebDriver driver;
    public  void automation() {



        try {
            System.setProperty("webdriver.chrome.driver","/home/webonise/Downloads/chromedriver");
           driver = new ChromeDriver();
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver,3);
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

            selectCheckDate(By.id("checkIn"),"October 2016","7");
            selectCheckDate(By.id("checkOut"),"October 2016","14");
            selectNoOfTraveller();

            WebElement clickFindFlightButton= driver.findElement(By.xpath(".//*[@id='SUBMIT_FLIGHTS']"));
            clickFindFlightButton.click();

            WebElement popupCloseButton = driver.findElement(By.xpath("html/body/span/div[2]"));

            wait.until(ExpectedConditions.visibilityOf(popupCloseButton));
            popupCloseButton.click();


            Thread.sleep(2000);

           // String winHandleBefore = driver.getWindowHandle();

            WebElement priceButton = driver.findElement(By.xpath(".//*[@id='taplc_flight_list_0']/div/div[2]/div[1]/div/div/div[1]/div[2]/a/div/span"));
            priceButton.click();

            WebElement updateSearch = driver.findElement(By.xpath("//*[@id=\"routeInfo\"]"));
            String FlightInfo=updateSearch.getText();

            WebElement price = driver.findElement(By.xpath("//*[@id=\"taplc_flight_list_0\"]/div/div[2]/div[1]/div/div/div[1]/div[2]/a/div/span/span"));
            String priceInString = price.getText();



           for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }


            System.out.println(FlightInfo);
            System.out.println(priceInString);
           // driver.close();
           // driver.quit();

           // WebElement actualPrice = driver.findElement(By.xpath(".//*[@id='ctrlFareSummary_lnkFareDetails']/em[2]"));

            //wait.until(ExpectedConditions.visibilityOf(actualPrice));
            ///System.out.println(actualPrice.getText());





            //WebElement inputFLightCheckOut = driver.findElement(By.id("checkOut"));
          //  inputFLightCheckOut.clear();

           // inputFLightCheckOut.sendKeys("14/8/2016");
           // inputFLightCheckOut.sendKeys(Keys.ENTER);


        }catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }//main


    public void selectNoOfTraveller(){

        WebElement travellers = driver.findElement(By.xpath(".//*[@id='fadults']"));
        travellers.click();
        WebElement traveller3 = driver.findElement(By.xpath(".//*[@id='fadults']/option[2]"));
        traveller3.click();

    }


    public void selectDateFromLeftMonth(String expectedDate){
            WebElement dataWidget = driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[2]/table/tbody"));
            List<WebElement> columns= dataWidget.findElements(By.tagName("td"));

            for(WebElement cell : columns){
                if(cell.getText().equals(expectedDate)){
                    cell.click();
                    break;
                }
            }

    }

    public void selectDateFromRightMonth(String expectedDate){
        WebElement dataWidget = driver.findElement(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[3]/table/tbody"));
        List<WebElement> columns= dataWidget.findElements(By.tagName("td"));

        for(WebElement cell : columns){
            if(cell.getText().equals(expectedDate)){
                cell.click();
                break;
            }
        }

    }

    public void selectCheckDate(By by, String expectedMonth,String expectedDate){

        try {
            WebElement inputFLightCheckIn = driver.findElement(by);
            inputFLightCheckIn.click();
            WebElement leftMonth;
            WebElement rightMonth;
            int indexOfExpectMonth;
            int indexOfLeftMonth;
            int indexOfRightMonth;
            String[] months = new String[]{"August 2016","September 2016","October 2016","November 2016","December 2016","January 2017","February 2017","March 2017","April 2017","May 2017","June 2017","July 2017"};
            WebElement shiftMonthButton;

            indexOfExpectMonth = Arrays.asList(months).indexOf(expectedMonth);

            while(true){
                leftMonth = driver.findElement(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[2]/table/thead/tr[1]/th"));
                rightMonth = driver.findElement(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[3]/table/thead/tr[1]/th"));
                indexOfLeftMonth = Arrays.asList(months).indexOf((String)leftMonth.getText());
                indexOfRightMonth = Arrays.asList(months).indexOf((String)rightMonth.getText());

                if(indexOfExpectMonth == indexOfLeftMonth){
                    selectDateFromLeftMonth(expectedDate);
                    break;

                }
                else if(indexOfExpectMonth == indexOfRightMonth){
                    selectDateFromRightMonth(expectedDate);
                    break;
                }
                else if(indexOfExpectMonth < indexOfLeftMonth){

                    if(driver.findElements(By.xpath(".//*[@id='overlayInnerDiv']/div/div[1]/span[1]")).size() ==0){
                        System.out.println(expectedMonth +" Not Found");
                        break;
                    }else
                    {
                        shiftMonthButton = driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[1]/span[1]"));
                        shiftMonthButton.click();
                    }

                }
                else if(indexOfExpectMonth > indexOfRightMonth){
                    if(driver.findElements(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[1]/span[2]")).size() ==0){
                        System.out.println(expectedMonth + "Not Found");
                        break;
                    }
                    else{
                        shiftMonthButton = driver.findElement(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[1]/span[2]"));
                        shiftMonthButton.click();
                    }

                }

            }           

            
            Thread.sleep(3000);
            // List<String> months ={"September 2016",};
           // WebElement monthAndYearLeft = driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[2]/table/thead/tr[1]/th"));
           // WebElement monthAndYearRight = driver.findElement(By.xpath(""));



        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void selectCheckOutDate(By by){

        try {
            WebElement inputFLightCheckOut = driver.findElement(by);
            inputFLightCheckOut.click();
            WebElement nextMonth;
            while(driver.findElements(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[1]/span[2]")).size() !=0)
            {
                nextMonth = driver.findElement(By.xpath("//*[@id=\"overlayInnerDiv\"]/div/div[1]/span[2]"));
                nextMonth.click();
                Thread.sleep(2000);

            }

            // List<String> months ={"September 2016",};
            // WebElement monthAndYearLeft = driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[2]/table/thead/tr[1]/th"));
            // WebElement monthAndYearRight = driver.findElement(By.xpath(""));



        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


       public static void main(String[] args){
           Selenium2Example selenium2Example= new Selenium2Example();
            selenium2Example.automation();


    }

}