package com.notepad.windows;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;

import static com.notepad.locators.NotePadLocators.textEditor;

public class NotepadWindow {
    private final WindowsDriver<WindowsElement> driver;

    public NotepadWindow(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
    }

    public void typeText(String text){
        driver.findElement(By.className(textEditor)).sendKeys(text);
    }
}