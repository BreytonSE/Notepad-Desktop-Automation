package com.notepad.validations;

import com.notepad.base.BaseTest;
import com.notepad.windows.NotepadWindow;
import org.testng.annotations.Test;

public class Type_Test extends BaseTest {

    @Test(description = "Verify you can type text on notepad text editor")
    public void typeTypeTextInNotepadTextEditor() {
        NotepadWindow notepadWindow = new NotepadWindow(driver);
        notepadWindow.typeText("I can type text in notepad via automation!");
    }
}