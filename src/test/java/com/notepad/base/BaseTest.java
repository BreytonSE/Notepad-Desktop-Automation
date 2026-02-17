package com.notepad.base;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;

import static com.notepad.manager.WinAppManager.*;

public class BaseTest {
    protected static WindowsDriver<WindowsElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        startWinAppDriver();
    }

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("app", "C:\\Windows\\notepad.exe");
       caps.setCapability("platformName", "Windows");
       caps.setCapability("deviceName", "WindowsPC");
       caps.setCapability("automationName", "Windows");
       driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), caps);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        stopWinAppDriver();
    }
}