package DriverInitialization_Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverInitialization {
    public static WebDriver driver;

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public void closeDriver()
    {
        driver.close();
    }
    public static ExtentReports getReportObject(String reportName) {
        String path = System.getProperty("user.dir") + reportName;
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

}
