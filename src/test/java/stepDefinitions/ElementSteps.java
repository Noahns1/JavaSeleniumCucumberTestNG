package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ElementSteps {
    WebDriver driver;

    @Given("the user is on the demoqa main page")
    public void theUserIsOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        WebElement currentAddressText = driver.findElement(By.xpath("//p[@id='currentAddress' and @class='mb-1']"));
        WebElement permanentAddressText = driver.findElement(By.xpath("//p[@id='permanentAddress' and @class='mb-1']"));

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
        WebElement box = driver.findElement(By.id("output"));
        String actualBox = box.getText();
        String expectedBox = "";
        Assert.assertEquals(actualBox, expectedBox);
    }

    @Then("window closes")
    public void windowCloses() {
        driver.close();
    }

    @When("the user clicks on Check Box tab")
    public void theUserClicksOnCheckBoxTab() {
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
    }

    @And("the user checks box")
    public void theUserChecksBox() {
        WebElement homeBox = driver.findElement(By.className("rct-checkbox"));
        homeBox.click();
    }


    @And("confirmation message appears after box is checked")
    public void confirmationMessageAppearsAfterBoxIsChecked() {
        WebElement checkBoxResult = driver.findElement(By.id("result"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(actualTextName, expectedTextName);

    }

    @And("the user clicks Home drop down button")
    public void theUserClicksHomeDropDownButton() {
        WebElement homeDropDown = driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn' and @title='Toggle']"));
        homeDropDown.click();
    }

    @And("the user clicks Desktop drop down button")
    public void theUserClicksDesktopDropDownButton() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        button.click();
    }

    @And("the user checks Commands box")
    public void theUserChecksCommandsBox() {
        WebElement commandButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"));
        commandButton.click();
    }

    @Then("result message for Commands appears")
    public void resultMessageForCommandsAppears() {
        WebElement checkBoxResult = driver.findElement(By.id("result"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "You have selected :\n" +
                "commands";
        Assert.assertEquals(actualTextName, expectedTextName);
    }

    @When("the user clicks on Radio Button tab")
    public void theUserClicksOnRadioButtonTab() {
        WebElement radioButtonTab = driver.findElement(By.id("item-2"));
        radioButtonTab.click();
    }

    @And("user clicks Yes button")
    public void userClicksYesButton() {
        WebElement radioButton = driver.findElement(By.id("yesRadio"));
        // by passes iframes
        try {
            radioButton.click();
        } catch(WebDriverException e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", radioButton);
        }
    }

    @Then("user verifies Yes confirmation")
    public void userVerifiesYesConfirmation() {
        WebElement checkBoxResult = driver.findElement(By.className("mt-3"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "You have selected Yes";
        Assert.assertEquals(actualTextName, expectedTextName);
    }

    @And("user clicks Impressive button")
    public void userClicksImpressiveButton() {
        WebElement radioButton = driver.findElement(By.id("impressiveRadio"));
        // by passes iframes
        try {
            radioButton.click();
        } catch(WebDriverException e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", radioButton);
        }
    }

    @Then("user verifies Impressive confirmation")
    public void userVerifiesImpressiveConfirmation() {
        WebElement checkBoxResult = driver.findElement(By.className("mt-3"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "You have selected Impressive";
        Assert.assertEquals(actualTextName, expectedTextName);
    }

    @And("user verifies No button is not clickable")
    public void userVerifiesNoButtonIsNotClickable() {
        WebElement radioNo = driver.findElement(By.cssSelector("input[id='noRadio']"));
        boolean selectNo = radioNo.isEnabled();

        // performing click operation if element is enabled
        if (!selectNo) {
            System.out.println("Radio button 'No' is disabled as expected");
        }
    }

    @When("user clicks on Web Tables tab")
    public void userClicksOnWebTablesTab() {
        WebElement radioButtonTab = driver.findElement(By.id("item-3"));
        radioButtonTab.click();
    }

    @And("user clicks add button")
    public void userClicksAddButton() {
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
    }

    @When("user fills in registration form")
    public void userFillsInRegistrationForm(DataTable dataTable) throws Throwable {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String field = entry.getKey();
            String value = entry.getValue();

            wait.until(ExpectedConditions.elementToBeClickable(By.id(field)));

            WebElement inputElement = driver.findElement(By.id(field));
            //js.executeScript("arguments[0].value='" + value + "';", inputElement);

            inputElement.sendKeys(value);
        }
    }

    @And("user clicks submit")
    public void userClicksSubmit() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Then("user verifies form is submitted with correct info")
    public void userVerifiesFormIsSubmittedWithCorrectInfo() {
        WebElement checkBoxResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "Noah\n" +
                "S\n" +
                "24\n" +
                "NS@mail.com\n" +
                "1\n" +
                "Selenium";
        Assert.assertEquals(actualTextName, expectedTextName);
    }

    @When("user clicks edit")
    public void userClicksEdit() {
        WebElement editButton = driver.findElement(By.id("edit-record-4"));
        editButton.click();
    }

    @And("user edits registration form inputs")
    public void userEditsRegistrationFormInputs(DataTable dataTable) throws Throwable {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String field = entry.getKey();
            String value = entry.getValue();

            wait.until(ExpectedConditions.elementToBeClickable(By.id(field)));

            WebElement inputElement = driver.findElement(By.id(field));

            inputElement.clear();
            inputElement.sendKeys(value);
        }
    }

    @Then("user verifies form is submitted with updated info")
    public void userVerifiesFormIsSubmittedWithUpdatedInfo() {
        WebElement checkBoxResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "Noah\n" +
                "Schlaupitz\n" +
                "24\n" +
                "NNS@mail.com\n" +
                "10\n" +
                "Selenium!";
        Assert.assertEquals(actualTextName, expectedTextName);
    }

    @When("user clicks Delete button")
    public void userClicksDeleteButton() {
        WebElement editButton = driver.findElement(By.id("delete-record-4"));
        editButton.click();
    }

    @Then("user verifies row is now empty")
    public void userVerifiesRowIsNowEmpty() {
        WebElement checkBoxResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]"));

        String actualTextName = checkBoxResult.getText();
        String expectedTextName = "       ";
        Assert.assertEquals(actualTextName, expectedTextName);
    }
}