package org.yukaTest.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.yukaTest.Pages.HomePage;
import org.yukaTest.Utilities.BrowserUtils;
import org.yukaTest.Utilities.ConfigurationReader;
import org.yukaTest.Utilities.Driver;

import java.io.IOException;

public class TimerPageStepDef {

    HomePage homePage = new HomePage(Driver.getDriver());

    public static void main(String[] args) throws IOException {
        // localhost'u başlatma
        startLocalhost();
    }

    private static void startLocalhost() throws IOException {

        // Yarn start komutunu çalıştırma
        ProcessBuilder processBuilder = new ProcessBuilder("yarn", "start");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
    }

    //url i configuration.properties dosyasından alıyorum
    public String GetProp(String a) {
        return ConfigurationReader.getProperty(a);
    }

    @Given("User should be able to go to home page")
    public void userShouldBeAbleToGoToHomePage() {
        BrowserUtils.waitFor(6);
        Driver.getDriver().get(GetProp("url"));

    }

    @And("Verify that the user is on the home page the timer")
    public void verifyThatTheUserIsOnTheHomePageTheTimer() {

        homePage.verifyOnTheTimer();
    }

    @When("User clicks Start button")
    public void userClicksStartButton() {

        homePage.startButton.click();
    }

    @Then("Start button should be visible")
    public void startButtonShouldBeVisible() {

        Assert.assertEquals(homePage.startButton.getText(), "Start");
    }

    @And("Start button must be clickable")
    public void startButtonMustBeClickable() {

        homePage.verifyStartButton();
    }

    @Given("User clicks Stop button")
    public void userClicksStopButton() {

        homePage.stopButton.click();
    }

    @Then("Stop button should be visible")
    public void stopButtonShouldBeVisible() {

        Assert.assertEquals(homePage.stopButton.getText(), "Stop");

    }

    @And("Stop button must be clickable")
    public void stopButtonMustBeClickable() {

        homePage.verifyStopButton();
    }

    @Given("User clicks Reset button")
    public void userClicksResetButton() {

        homePage.resetButton.click();
    }

    @Then("Reset button should be visible")
    public void resetButtonShouldBeVisible() {

        Assert.assertEquals(homePage.resetButton.getText(), "Reset");
    }

    @And("Reset button must be clickable")
    public void resetButtonMustBeClickable() {

        homePage.verifyResetButton();

    }

    @When("the timer reaches the {int} minutes")
    public void theTimerReachesTheThMinute(int fifteenth) {

        homePage.resetButton.click();
        homePage.startButton.click();
        homePage.verify15thButton(fifteenth);

    }

    @When("the timer reaches the {int} minute")
    public void theTimerReachesTheMinute(int zeroth) {

        homePage.resetButton.click();
        homePage.startButton.click();
        homePage.verify0thButton(zeroth);

    }

    @Then("the timer is verified in {int} minute")
    public void theTimerIsVerifiedInMinutes(int zeroth) {

        Assert.assertFalse(homePage.startButton.isSelected());

    }

    @And("start button is not clickable")
    public void startButtonCannotBeClicked() {

        Assert.assertFalse(homePage.startButton.isSelected());

    }


    @And("Stop button is not clickable")
    public void stopButtonIsNotClickable() {

        Assert.assertFalse(homePage.stopButton.isSelected());

    }
}
