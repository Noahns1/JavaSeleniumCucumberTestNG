package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSteps {

    WebDriver driver;
    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
    }

    @When("the user clicks on Forms button")
    public void theUserClicksOnFormsButton() {
        WebElement formButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]"));
        formButton.click();
    }

    @Then("the user is redirected to the Forms page")
    public void theUserIsRedirectedToTheFormsPage() {
    }

    @When("the user clicks on practice form tab")
    public void theUserClicksOnPracticeFormTab() {

    }

    @And("the user fills in sections and selects all options")
    public void theUserFillsInSectionsAndSelectsAllOptions() {

    }

    @And("the user submits student registration form")
    public void theUserSubmitsStudentRegistrationForm() {

    }

    @Then("the user will correct student registration information displayed")
    public void theUserWillCorrectStudentRegistrationInformationDisplayed() {
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
