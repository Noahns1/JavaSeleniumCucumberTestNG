package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ElementSteps {
    WebDriver driver;

    @Given("the user is on the demoqa main page")
    public void theUserIsOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        //WebElement searchInput = driver.findElement(By.name("q"));
        //searchInput.sendKeys("https://demoqa.com/");
        //searchInput.submit();
    }

    @When("the user clicks on Elements button")
    public void theUserClicksOnElementsButton() {
        WebElement elements = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        elements.click();
    }

    @Then("the user is redirected to elements page")
    public void theUserIsRedirectedToElementsPage() {
        WebElement textElements = driver.findElement(By.className("main-header"));
        String actualText = textElements.getText();
        String expectedText = "Elements";
        Assert.assertEquals(actualText, expectedText);
    }

    @When("the user clicks on Text Box tab")
    public void theUserClicksOnTextBoxTab() {
        WebElement textBox = driver.findElement(By.id("item-0"));
        textBox.click();
    }


    @And("the user fills in all sections")
    public void theUserFillsInAllSections() {
        // Web Elements
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        // input
        fullName.sendKeys("NNS");
        email.sendKeys("NNS@mail.com");
        currentAddress.sendKeys("my address");
        permanentAddress.sendKeys("my other address");

    }

    @And("the user selects submit")
    public void theUserSelectsSubmit() {
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    @Then("the user should see submitted information displayed")
    public void theUserShouldSeeSubmittedInformationDisplayed() {
        // web elements
        WebElement fullNameText = driver.findElement(By.id("name"));
        WebElement emailText = driver.findElement(By.id("email"));
        WebElement currentAddressText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]"));
        WebElement permanentAddressText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]"));

        // actual vs expected for name
        String actualTextName = fullNameText.getText();
        String expectedTextName = "Name:NNS";
        Assert.assertEquals(actualTextName, expectedTextName);

        // actual vs expected for email
        String actualTextEmail = emailText.getText();
        String expectedTextEmail = "Email:NNS@mail.com";
        Assert.assertEquals(actualTextEmail, expectedTextEmail);

        // actual vs expected for current address
        String actualTextCAddress = currentAddressText.getText();
        String expectedTextCAddress = "Current Address :my address";
        Assert.assertEquals(actualTextCAddress, expectedTextCAddress);

        // actual vs expected for permanent address
        String actualTextPAddress = permanentAddressText.getText();
        String expectedTextPAddress = "Permananet Address :my other address";
        Assert.assertEquals(actualTextPAddress, expectedTextPAddress);
    }

    @But("the user inputs incorrect email format")
    public void theUserInputsIncorrectEmailFormat() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.clear();
        email.sendKeys("NNSmail.com");
    }

    @Then("the user should not see submitted information")
    public void theUserShouldNotSeeSubmittedInformation() {
        WebElement box = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div"));
        String actualBox = box.getText();
        String expectedBox = "";
        Assert.assertEquals(actualBox, expectedBox);
    }

    @Then("window closes")
    public void windowCloses() {
        driver.close();
    }
}