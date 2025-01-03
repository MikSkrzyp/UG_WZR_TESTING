package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import io.cucumber.java.an.E;
import io.cucumber.java.bs.A;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import waits.WaitForElement;

import javax.swing.*;

import static org.testng.AssertJUnit.*;

public class EconomicAnalytics extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/div[3]")
    private WebElement title;


    @FindBy(css = "#skrypt-wzr > form:nth-child(7) > div:nth-child(7) > label > input")
    private WebElement bachelorRadio;


    @FindBy(css="#skrypt-wzr > p.komunikat")
    private WebElement alert;

    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfIcon;

    @FindBy(name = "lata")
    private WebElement select;


    public static EconomicAnalytics enterIframe(){
        DriverManager.getDriver().switchTo().frame(0);
        return new EconomicAnalytics();
    }
    public static void quitIframe(){
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public EconomicAnalytics assertTitle(){
        WaitForElement.waitForElementToBeVisible(title);
        assertEquals("Analityka gospodarcza",title.getText());

        return new EconomicAnalytics();
    }

    public EconomicAnalytics clickBachelorRadio() {
        WaitForElement.waitForElementToBeVisible(bachelorRadio);
       new Actions(DriverManager.getDriver()).scrollByAmount(0,200).perform();
        bachelorRadio.click();
        return new EconomicAnalytics();
    }
    public EconomicAnalytics assertVisibilityOfPdfIcon() throws InterruptedException {
        Thread.sleep(3000);
        assertFalse(pdfIcon.isDisplayed());

        return new EconomicAnalytics();
    }

    public EconomicAnalytics alertThatProgramWasNotPublished(){

        WaitForElement.waitForElementToBeVisible(alert);
        assertEquals("Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.",alert.getText());

        return new EconomicAnalytics();
    }

    public EconomicAnalytics select20162017(){
        WaitForElement.waitForElementToBeVisible(select);
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("2016-2017");
        return new EconomicAnalytics();
    }
    public EconomicAnalytics assertSelectValue(){
        Select dropdown = new Select(select);
        assertEquals("2016-2017",dropdown.getFirstSelectedOption().getText());
        return new EconomicAnalytics();
    }
}