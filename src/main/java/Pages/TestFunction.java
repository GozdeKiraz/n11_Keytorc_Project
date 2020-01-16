package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



    public class TestFunction {
    public static WebDriver driver;

    public TestFunction(WebDriver webDriver) {
        driver = webDriver;

    }
    

    //Anasayfaya girdikten sonra giriş yap butonuna git
    public WebElement btnSignIn() {
        return driver.findElement(By.className("btnSignIn"));
    }

    //Giriş yap sayfasındaki alanı doldur
    public WebElement txtEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement txtPassword() {
        return driver.findElement(By.id("password"));
    }

    //Giriş yap butonu ile login olma
    public WebElement btnLogin() {
        return driver.findElement(By.id("loginButton"));
    }

    //Ürün arama
    public WebElement txtSearch() {
        return driver.findElement(By.id("searchData"));
    }

    public WebElement btnSearch() {
        return driver.findElement(By.className("searchBtn"));
    }

    //İkinci sayfaya gitme
    public WebElement btnPage2() {
        return driver.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a:nth-child(2)"));
    }

    //Seçilen ürünü favorilere ekleme
    public WebElement btnFavAdd() {
        return driver.findElement(By.xpath("//*[@id=\"p-336735730\"]/div[1]/span"));
    }

    //Hesabım üzerinde favorilerim sayfasına gidebilmek için fareyi imlece götür ve favorilerim sayfasına git
    public void hoverMyAccount() {
       Actions action = new Actions(driver);

       WebElement mainMenu = driver.findElement(By.className("myAccount"));
       action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]"))).click().build().perform();

       WebElement listItemTitle = driver.findElement(By.className("listItemTitle"));
       action.moveToElement(listItemTitle).moveToElement(driver.findElement(By.xpath("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a")));
    }



    //Favorilerim/Listelerim sayfasındaki favorilerim alanına tıklama
    public WebElement btnMyFav() {
        return driver.findElement(By.xpath("//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a"));
   }

    //Favorilerden silme
    public WebElement btnDelFav() {
        return driver.findElement(By.className("deleteProFromFavorites"));
    }

    //Silme işlemini gerçekleştirdiğimize dair açılan pencereyi kapatma
    public WebElement btnPopUpClose() {
        return driver.findElement(By.className("closeBtn"));
    }


}


