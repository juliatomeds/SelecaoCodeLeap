package pageObjects;

import org.openqa.selenium.By;

public class Login {
    public static final By Title = By.xpath("//h1[text()='Welcome to CodeLeap network!']");
    public static final By SubTitle = By.xpath("//p[text()='Please enter your username']");
    public static final By InputName = By.xpath("//input[@placeholder='John doe']");
    public static final By ButtonEnter = By.xpath("//button[@class='btn-fill btn-upper']");

}
