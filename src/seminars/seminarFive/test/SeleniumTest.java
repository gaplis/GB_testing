import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SeleniumTest {
//    Задание 4: Напишите автоматизированный тест, который выполнит следующие шаги:
//               1. Открывает главную страницу Google.
//               2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
//               3. В результатах поиска ищет ссылку на официальный сайт Selenium
//               (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
//               результатов поиска.

    @Test
    public void checkBrowserTest() {
//        System.setProperty("webdriver.edge.driver", "С:/Users/gapli/Downloads/edgedriver_win64/msedgedriver.exe");
        boolean a = false;
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        List<WebElement> seleniumLink = driver.findElements(By.cssSelector("div"));

        for (WebElement webElement : seleniumLink) {
            if (webElement.getText().contains("https://www.selenium.dev")) {
                a = true;
            }
        }

        assertTrue(a);
        driver.quit();
    }

//    Задание 5: Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
//    сайте https://www.saucedemo.com/.
//    Данные для входа - логин: "standard_user", пароль: "secret_sauce".
//    Проверить, что авторизация прошла успешно и отображаются товары.
//    Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
//    данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
//    отображаются продукты (productsLabel.getText() = "Products").


}
