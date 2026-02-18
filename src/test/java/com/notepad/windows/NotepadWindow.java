package com.notepad.windows;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.notepad.locators.NotePadLocators.textEditor;

public class NotepadWindow {
    private final WindowsDriver<WindowsElement> driver;
    private final WebDriverWait wait;

    public NotepadWindow(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void typeText(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(textEditor)));
        driver.findElement(By.className(textEditor)).sendKeys(text);
    }
}