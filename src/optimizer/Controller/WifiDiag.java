package optimizer.Controller;

import java.lang.ProcessBuilder;
import java.io.IOException;
/**
 * Jharris
 * Version 1.0.0
 */
public class WifiDiag {
    public static void run (String[] args) throws IOException {
        args = new String[] {"/bin/bash", "-c", "networksetup -setairportpower airport off; networksetup -setairportpower airport on", "with", "args"};
        Process proc = new ProcessBuilder(args).start();
    }
}