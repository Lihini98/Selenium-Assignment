package assignment;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpValidation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://cog-stg.incubatelabs.com/");

        driver.manage().window().maximize();

        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='https://cog-stg.incubatelabs.com/user/sign_up']"));
        signUpButton.click();

        WebElement signUpWithEmailButton = driver.findElement(By.xpath("//a[@id='continue_with_email_signup']"));
        signUpWithEmailButton.click();

        driver.findElement(By.id("fname")).sendKeys("Lihini");
        driver.findElement(By.id("lanme")).sendKeys("Jayasinghe");
        driver.findElement(By.id("email")).sendKeys("lihinidananjana@gmail.com");
//        Select countryDropdown = new Select(driver.findElement(By.xpath ("//*[@id=\"sign-up-form\"]/div[4]/div/div/uly")));
//        countryDropdown.selectByVisibleText("United States");
        driver.findElement(By.id("mobileNum")).sendKeys("0712092430");
        driver.findElement(By.id("pw")).sendKeys("Lihini@071");

        String email = driver.findElement(By.id("email")).getAttribute("value");
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format!");
        } else {
            System.out.println("Valid email format!");
        }

        String phoneNumber = driver.findElement(By.id("mobileNum")).getAttribute("value");
        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number format!");
        } else {
            System.out.println("Valid phone number format!");
        }

        String password = driver.findElement(By.id("pw")).getAttribute("value");
        if (!isValidPassword(password)) {
            System.out.println("Invalid password format! Ensure it has minimum length and contains special characters.");
        } else {
            System.out.println("Valid password format!");
        }

        WebElement signUpFormButton = driver.findElement(By.xpath("//button[@id='submit']"));
        signUpFormButton.click();
        
        driver.quit();
    }

    private static boolean isValidEmail(String email) {
    	
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
    	
        return phoneNumber.matches("\\d{10}");
    }

    private static boolean isValidPassword(String password) {
        
        return password.length() >= 8 && password.matches(".*[!@#$%^&*()_+{}|:<>?\\[\\]~-].*");
    }
}
