package page.objects;

import driver.manager.DriverExtensions;
import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import waits.WaitForElement;

import static org.testng.AssertJUnit.*;

public class EconomicAnalytics extends PageObjectInitializer{

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/p[2]")
    private WebElement economicAnalyticsAlert;

    @FindBy(xpath = "//*[@id=\"skrypt-wzr\"]/form[2]/div[2]/label/input")
    private WebElement bachelorCheckbox;

    @FindBy(css = "#skrypt-wzr > form > div > a")
    private WebElement pdfIcon;

    public EconomicAnalytics checkURL(){
        assertEquals("https://wzr.ug.edu.pl/wydzial/programy-studiow/studia-w-jezyku-polskim/studia-i-stopnia", DriverExtensions.getCurrentUrl());
        return this;
    }

    public EconomicAnalytics checkAlert(){
        WaitForElement.waitForElementToBeVisible(economicAnalyticsAlert);
        assertEquals("Program studiów dla specjalności Analityka gospodarcza na rok akademicki 2024-2025 nie został opublikowany.",economicAnalyticsAlert.getText());
        return this;
    }
    public EconomicAnalytics clickBachelorCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        bachelorCheckbox.click();
        return this;
    }

    public EconomicAnalytics assureThatPDFIconIsNotVisible() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(pdfIcon.isDisplayed());
        return this;
    }

}