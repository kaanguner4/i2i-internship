package com.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Chrome driver ayarı
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Siteyi aç
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // Kullanıcı adı gir
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("standard_user");

            // Şifre gir
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("secret_sauce");

            // Login butonuna tıkla
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Sayfanın yüklenmesi için kısa bekleme
            Thread.sleep(2000);

            // Başarılı giriş kontrolü
            boolean isLoginSuccessful = driver.getPageSource().contains("Products");

            if (isLoginSuccessful) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed!");
            }

            // Tarayıcıyı 5 saniye açık bırak
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
