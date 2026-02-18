package com.notepad.windows;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class NotepadWindow {
    private final WindowsDriver<WindowsElement> driver;

    public NotepadWindow(WindowsDriver<WindowsElement> driver) {
        this.driver = driver;
    }

    public void typeText(String text){
        driver.switchTo().activeElement().sendKeys(text);
    }
}