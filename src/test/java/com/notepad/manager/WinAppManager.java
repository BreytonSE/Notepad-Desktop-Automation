package com.notepad.manager;

import java.io.IOException;
import java.net.Socket;

public class WinAppManager {
    private static Process winAppProcess;

    public static void startWinAppDriver() throws IOException {
        String exePath = System.getenv("WINAPPDRIVER_HOME") + "\\WinAppDriver.exe";
        winAppProcess = new  ProcessBuilder(exePath)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start();
        waitForServerToBeReady();
    }

    public static void stopWinAppDriver(){
        if (winAppProcess != null) {
            winAppProcess.destroyForcibly();
        }
    }

    private static void waitForServerToBeReady(){
        int timeoutSeconds = 30;
        long startTime = System.currentTimeMillis();

        while((System.currentTimeMillis() - startTime) < timeoutSeconds * 1000L){
            try (Socket socket = new Socket("127.0.0.1",4723);){
                return; // Port is open
            }catch (Exception ignored){}

            try{
                Thread.sleep(500);
            }catch (InterruptedException ignored){}
        }
        throw new RuntimeException("WinAppDriver did not start within timeout.");
    }
}