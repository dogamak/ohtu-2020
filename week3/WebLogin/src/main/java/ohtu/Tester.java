package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        sleep(2);

        Random r = new Random();
        
        /* <Original Code>
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        */

        /* <Unsuccessfull login using wrong password>
        driver.findElement(By.linkText("login")).click();
        sleep(2);

        driver.findElement(By.name("username")).sendKeys("pekka");
        driver.findElement(By.name("password")).sendKeys("inahuj");
        sleep(2);

        driver.findElement(By.name("login")).submit();
        sleep(3);
        */

        /* <Creation of a new user> */
        driver.findElement(By.linkText("register new user")).click();
        sleep(2);

        String username = "juhani" + r.nextInt(10000);

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("inahuj123");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("inahuj123");
        sleep(2);

        driver.findElement(By.name("signup")).submit();
        sleep(3);

        /* <Logging in with the user created in the previous case> */
        driver.findElement(By.linkText("continue to application mainpage")).click();
        sleep(2);

        driver.findElement(By.linkText("logout")).click();
        sleep(2);

        driver.findElement(By.linkText("login")).click();
        sleep(2);

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("inahuj123");
        sleep(2);

        driver.findElement(By.name("login")).submit();
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
