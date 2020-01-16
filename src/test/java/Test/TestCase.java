package Test;

import Pages.TestFunction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class TestCase {

    public static WebDriver driver;
    private static String baseUrl;

    //Send keys içerisine yazılacak textleri tanımlama
    public static String email = "gzdkiraz@gmail.com";
    public static String userPassword = "Hm5.g35918";
    public static String search="samsung";


    //Modelimizin bulunduğu paket dosyası
    public static TestFunction elementPage;

    //Sayfanın yüklenmesi için gerekli tanımlamalar
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GOZDE\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.n11.com/";

       //Sayfa içerisinde aşağı kaydırma
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");

        //Driver elementlere erişim için 10 sn bekleme süresi tanıma
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        //Sayfaların beklenmesi için süre  tanıma
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);

        elementPage = new TestFunction(driver);
    }

    //TestFunction sınıfında tanımladığımız methodları çağırıp test etme
    @Test
    public void testElements() throws Exception {
        driver.get(baseUrl);
        elementPage.btnSignIn().click();
        elementPage.txtEmail().sendKeys(email);
        elementPage.txtPassword().sendKeys(userPassword);
        elementPage.btnLogin().click();
        elementPage.txtSearch().sendKeys(search);
        elementPage.btnSearch().click();
        elementPage.btnPage2().click();
        elementPage.btnFavAdd().click();
        elementPage.hoverMyAccount();
        elementPage.btnMyFav().click();
        elementPage.btnDelFav().click();
        elementPage.btnPopUpClose().click();

    }
    //-----------Assertions-----------------

    //Anasayfanın açıldığını onaylama
    @Test
    public void testAssertionsHomePage() throws Exception {
        driver.get(baseUrl);
        String urlEquals = "https:/www.n11.com/";
        assertEquals(baseUrl, urlEquals);
        System.out.println("Successfully passed!");


    }

    //"samsung" araması yaptığını onaylama
    @Test
    public void testAssertionsSearch(){
        driver.get("https://www.n11.com/arama?q=samsung");
        String urlEquals="https://www.n11.com/arama?q=samsung";
        assertEquals("https://www.n11.com/arama?q=samsung",urlEquals);
        System.out.println("Successfully passed!");
    }


    //İkinci sayfaya gittiğini onaylama
    @Test
    public void testAssertionsNextTwoPage(){
     driver.get("https://www.n11.com/arama?q=samsung&pg=2");
     String urlEquals="https://www.n11.com/arama?q=samsung&pg=2";
     assertEquals("https://www.n11.com/arama?q=samsung&pg=2",urlEquals);
     System.out.println("Successfully passed!");
    }


}