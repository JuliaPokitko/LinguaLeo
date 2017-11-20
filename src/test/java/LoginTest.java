import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;



public class LoginTest {

    WebDriver driver = null;

    // выполниться прежде чем методы с аннотацией @Test
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\geekgroup-10\\Desktop\\hillel\\fakeUITest\\drivers\\geckodriver-18.0.exe");
        driver = new FirefoxDriver(); // выбираем с каким браузером запуститься всем тестам в этом класса





    }

    // отделяем обычный метод в Java от метода, которые будет содержать проверки
    // так же помогает библиотеке формировать отчеты отделя методы, которые просто выполнились
    // от методов, которые будут отображать результат прохождения тестов
    @Test
    public void successfulLoginTest() {
        driver.navigate().to("http://google.com"); // переходим на сайт
        String appTitle = driver.getTitle();
        System.out.println("Application title is :: " + appTitle);

        String expectedTitle = "Google";

        assertEquals(appTitle, expectedTitle); // с помощью библиотеки TestNG выполняем сравнение занчений.
        // Если значения совпадут, то тесты буду зелеными
        // Если значения не совпадут, то тесты буду красными/оранжевыми

        driver.get("https://lingualeo.com/ru");
        WebElement button = driver.findElement(By.id("headEnterBtn"));
        button.click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/div/div[1]/input"));
        email.sendKeys("pokitkojulia@gmail.com");
        WebElement password = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/div/div[2]/input"));
        password.sendKeys("leo123456");
        WebElement submit = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/button"));
        submit.click();
        assertEquals(driver.getTitle(),"Мои задания", "Title not correct");
        WebElement myProgress = driver.findElement(By.className("menu-link-text"));
        myProgress.click();
        //WebElement expectedText = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/ul/li[2]/a/i"));
        //assertEquals(expectedText.getText(), "Сытость Лео", "test passed");


        driver.close();// закрываем окно браузера
    }

    @Test
    public void failedTest() {
        driver.navigate().to("http://google.com"); // переходим на сайт
        String appTitle = driver.getTitle();
        System.out.println("Application title is :: " + appTitle);

        String expectedTitle = "Google";

        assertEquals(appTitle, expectedTitle); // с помощью библиотеки TestNG выполняем сравнение занчений.
        // Если значения совпадут, то тесты буду зелеными
        // Если значения не совпадут, то тесты буду красными/оранжевыми

        driver.get("https://lingualeo.com/ru");
        WebElement button = driver.findElement(By.id("headEnterBtn"));
        button.click();
        WebElement email = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/div/div[1]/input"));
        email.sendKeys("pokitkojulia1@gmail.com");
        WebElement password = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/div/div[2]/input"));
        password.sendKeys("leo2123456");
        WebElement submit = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/form/button"));
        submit.click();
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/p"));
        assertEquals(errorMessage.getText(),"Данного email не существует");


        driver.close();// закрываем окно браузера

    }

}
