package optimizer.Controller;

import java.io.*;

public class OptimizerController {


    /**
     * For cachedMemoryCleaner we need to use “purge” command.
     * The purge command forces disk and memory caches to be emptied, offering a ‘cold disk buffer cache’ which is
     * similar to the state of the operating system after a reboot. Of course, the benefit of using purge rather
     * than rebooting is that you don’t have to restart the machine and you can maintain currently active applications
     * while still freeing up memory.
     * Purge command needs root access and accordingly password.
     * So, we need to send psw immediately with command string, so the password must already be known to the java class.
     * E.g. class can get psw from your UI classes and save to String psw when the application starts.
     * * @param password
     */
    public static int cachedMemoryCleaner(String password) {
        String outTemp = "";
        String outStart = "";
        String outFinish = "";
        double fileBackedPagesStart;
        double fileBackedPagesFinish;
        Process process = null;
        String commandVmStat = "vm_stat";
        String[] commandPurge = {"sh", "-c", "echo " + password +  " | sudo -S purge"};

        try {
            process = Runtime.getRuntime().exec(commandVmStat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader outputStart = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            while ((outTemp = outputStart.readLine()) != null) {
                outStart += outTemp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileBackedPagesStart = Parser.parseOutVmstatCommand(outStart);
        System.out.println("Current Cached Files Size: " + fileBackedPagesStart + " pages" + "(page size of 4096 bytes)");

        try {
            process = Runtime.getRuntime().exec(commandPurge);
            Thread.sleep(500);
            process = Runtime.getRuntime().exec(commandVmStat);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader outputFinish = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            while ((outTemp = outputFinish.readLine()) != null) {
                outFinish += outTemp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileBackedPagesFinish = Parser.parseOutVmstatCommand(outFinish);
        System.out.println("Optimized Cached Files Size: " + fileBackedPagesFinish + " pages" + "(page size of 4096 bytes)");

        double improvement =(100-(fileBackedPagesFinish*100/fileBackedPagesStart));
        int result = (int) Math.round(improvement);
        System.out.println("Optimization " + result +"%"); //test

        return result;
    }

    /**
     * {trashCleaner}
     * Trash cleaning. Delete all files and folders from the Trash.
     */
    public static void trashCleaner() {
        Process process = null;
        String[] trashClean = {"sh", "-c", "rm -Rf ~/.Trash/*"};
        String[] trashClean2 = {"sh", "-c", "rm -Rf /Volumes/*/.Trashes"};
        try {
            process = Runtime.getRuntime().exec(trashClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {casheCleaner/casheCleaner2}
     * User cache makes up the majority of Mac junk on your system.
     * A good user cache cleaning could free up gigabytes
     * of free space and speed up your Mac in the process.
     * Need to close all apps before and reboot system after execute these methods.
     */
    public static void cacheStorageCleaner() {
        Process process = null;
        String[] cacheClean = {"sh", "-c", "Rm -rf ~/Library/Caches/*"};
        String[] cacheClean1 = {"sh", "-c", "Rm -rf /Library/Caches/*"};
        try {
            process = Runtime.getRuntime().exec(cacheClean1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {cacheDNSCleaner}
     * DNS cache is old cache entries that translate internet domain  names
     * (example.com) into IP addresses on your Mac. Clear DNS cache regularly to make sure all websites work correctly.
     */
    public static void cacheDNSCleaner (String password) {
        Process process = null;
        String[] cacheClean = {"sh", "-c", "echo " + password +  " | sudo killall " +
                "-HUP mDNSResponder"};
        try {
            process = Runtime.getRuntime().exec(cacheClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

