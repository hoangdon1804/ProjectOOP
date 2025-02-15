package data;

import data.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The Registrar class is used to navigate the register menu of X
 */

public class Registrar {
      public static void register(WebDriver driver) {
            System.out.println("/// ________Registering________ ///");
            /// ____Initialize wait and element____ ///
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(Constant.HUGE_WAIT_TIME));
            WebElement element;

            /// Enter email
            try {
                  element = wait.until(
                          ExpectedConditions.visibilityOfElementLocated(
                                  By.name("text")
                          )
                  );
                  Sleeper.sleep(Constant.SMALL_WAIT_TIME);
                  String s = "viptop375@gmail.com\n";

                  for(int i = 0; i < s.length(); i++) {
                        element.sendKeys((s.charAt(i) + ""));
                        Thread.sleep(100);
                  }
                  System.out.println("Email entered");

            } catch (Exception e) {
                  throw new RuntimeException("Enter email unsuccessfully");
            }


            /// Enter username
            // IMPORTANT NOTE: in some first register trials it is not needed to enter username,
            // but in some later trial it becomes necessary.
            // I absolutely have no idea about the reason behind this behavior,
            try {
                  element = wait.until(
                          ExpectedConditions.visibilityOfElementLocated(
                                  By.name("text")
                          )
                  );
                  Sleeper.sleep(Constant.SMALL_WAIT_TIME);
                  element.sendKeys("tuanhoang159917\n");
                  System.out.println("Username entered");

            } catch (Exception e) {
                  System.out.println("Username omitted/entered unsuccessfully");
            }

            /// Enter password
            try{
                  element = wait.until(
                          ExpectedConditions.visibilityOfElementLocated(
                                  By.name("password")
                          )
                  );
                  Sleeper.sleep(Constant.SMALL_WAIT_TIME);
                  element.sendKeys("alo113ak\n");
                  System.out.println("Password entered");
            } catch (Exception e) {
                  throw new RuntimeException("Enter password unsuccessfully");
            }

            Sleeper.sleep(Constant.HUGE_WAIT_TIME);
            System.out.println("Registered successfully!");
            System.out.println();
      }
}
