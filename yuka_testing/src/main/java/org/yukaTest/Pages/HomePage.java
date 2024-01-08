package org.yukaTest.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yukaTest.Utilities.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='button-container']//p[@class='button-value']")
    public WebElement startButton;

    @FindBy(xpath = "(//div[@class='button-container']//p[@class='button-value'])[2]")
    public WebElement stopButton;

    @FindBy(xpath = "(//div[@class='button-container']//p[@class='button-value'])[3]")
    public WebElement resetButton;

    @FindBy(css = ".time-display")
    public WebElement timeDisplay;

    public void verifyOnTheTimer() {

        // Elementin tüm metin içeriği alındı
        String tumMetin = timeDisplay.getText();

        // ":" karakteriyle tüm metin parçalandı
        String[] parcalananMetin = tumMetin.split(":");

        // İlk parça, yani saat değeri alınır
        String saatDegeri = parcalananMetin[0].trim();

        Assert.assertTrue(saatDegeri.contains("25"));
    }

    public void verifyStartButton() {

        // WebDriverWait oluştur, maksimum bekleme süresi belirlenir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

        try {
            // Belirli bir süre boyunca her saniye dinamik olarak değişen sayaç değeri bekleyerek kontrol edilir
            for (int i = 0; i < 60; i++) {

                // Sayaç elementini bekleyerek bulunur
                wait.until(ExpectedConditions.visibilityOf(timeDisplay));

                // Sayaç değeri alınır
                String counterValue = timeDisplay.getText();

                // Sayaç değeri parçalanır
                String[] values = counterValue.split(":");

                int dakika = Integer.parseInt(values[0].trim());

                // Assert işlemi: Dakika değerinin 24 olduğu kontrol edildi
                if (dakika == 24) {
                    System.out.println("24. dakikaya gelindi!");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyStopButton() {

        // WebDriverWait oluştur, maksimum bekleme süresi belirlenir
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));

        try {
            // Belirli bir süre boyunca her saniye dinamik olarak değişen sayaç değeri bekleyerek kontrol edilir
            for (int i = 0; i < 60; i++) {

                // Sayaç elementini bekleyerek bulunur
                wait.until(ExpectedConditions.visibilityOf(timeDisplay));

                // Sayaç değeri alınır
                String counterValue = timeDisplay.getText();

                // Sayaç değeri parçalanır
                String[] values = counterValue.split(":");

                int saniye = Integer.parseInt(values[1].trim());

                // Assert işlemi: saniye değerinin 59 olduğu kontrol edildi
                if (saniye == 59) {
                    System.out.println("59. saniyeye gelindi");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyResetButton() {

        // Elementin tüm metin içeriği alındı
        String tumMetin = timeDisplay.getText();

        // ":" karakteriyle tüm metin parçalandı
        String[] parcalananMetin = tumMetin.split(":");

        // İlk parça, yani saat değeri alınır
        String saatDegeri = parcalananMetin[0].trim();

        Assert.assertTrue(saatDegeri.contains("25"));
    }

    public void verify15thButton(int fifteenth) {

        try {
            // Sayfanın tam yüklenmesi beklenir
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Beklenen zamanı ayarlandı
            String expectedTime = "15:00";

            // 600 saniye boyunca her saniye kontrol edildi
            for (int i = 0; i < 600; i++) {
                // Elementin metni alınır
                String displayedTime = timeDisplay.getText();

                // Zaman kontrol edilir
                if (displayedTime.equals(expectedTime)) {
                    System.out.println("15. dakikaya geldiniz !");
                    break;
                }
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verify0thButton(int zeroth) {

        try {
            // Sayfanın tam yüklenmesi beklenir
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Beklenen zamanı ayarlandı
            String expectedTime = "00:00";

            // 1500 saniye boyunca her saniye kontrol edildi
            for (int i = 0; i < 1500; i++) {
                // Elementin metni alınır
                String displayedTime = timeDisplay.getText();

                // Zaman kontrol edilir
                if (displayedTime.equals(expectedTime)) {
                    System.out.println("Time is up.");
                    break;
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}