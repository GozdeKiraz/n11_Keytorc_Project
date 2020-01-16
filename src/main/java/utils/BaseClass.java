package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Elemanı bulana kadar bekleme
    public WebElement element(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return  driver.findElement(locator);
    }

}
