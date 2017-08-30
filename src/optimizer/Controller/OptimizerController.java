package optimizer.Controller;

import java.io.*;

/**
 * Created by nemo on 13.05.17.
 */

public class OptimizerController {

    private static String password;
    private static String login;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        OptimizerController.password = password;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        OptimizerController.login = login;
    }

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
    public static int cachedMemoryCleaner() {
        String outTemp = "";
        String outStart = "";
        String outFinish = "";
        double fileBackedPagesStart;
        double fileBackedPagesFinish;
        Process process = null;
        String commandVmStat = "vm_stat";
        String[] commandPurge = {"/bin/bash", "-c", "echo " + password + " | sudo -S purge"};

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
        System.out.println(outStart);
        //Parsing outStart
        /*//Test option. No parser class used
        String [] array = outStart.split("File-backed pages:");
        String [] array2 = array[1].split("Anonymous pages:");
        fileBackedPagesStart = Double.parseDouble(array2[0]);
        System.out.println("Current Cached Files Size: " + fileBackedPagesStart + " pages" + "(page size of 4096 bytes)");*/

        fileBackedPagesStart = Parser.parseOutVmstatCommand(outStart);
        System.out.println("Current Cached Files Size: " + fileBackedPagesStart + " pages" + "(page size of 4096 bytes)");

        try {
            process = Runtime.getRuntime().exec(commandPurge);
            Thread.sleep(10000);
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
        //Parsing outFinish
        /*//Test option. No parser class used
        String [] array3 = outFinish.split("File-backed pages:");
        String [] array4 = array[1].split("Anonymous pages:");
        fileBackedPagesFinish = Double.parseDouble(array2[0]);
        System.out.println("Current Cached Files Size: " + fileBackedPagesFinish + " pages" + "(page size of 4096 bytes)");*/

        fileBackedPagesFinish = Parser.parseOutVmstatCommand(outFinish);
        System.out.println("Optimized Cached Files Size: " + fileBackedPagesFinish + " pages" + "(page size of 4096 bytes)");

        process.destroy();

        double improvement =(100-(fileBackedPagesFinish*100/fileBackedPagesStart));
        int result = (int) Math.round(improvement);

        return result;
    }



    /**
     * {trashCleaner}
     * Trash cleaning. Delete all files and folders from the Trash.
     *
     *
     */
    public static void trashCleaner() {
        Process process = null;
        String[] trashClean = {"/bin/bash", "-c", "echo " + password + " | sudo rm -rf ~/.Trash/*"};
        try {
            process = Runtime.getRuntime().exec(trashClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }

    public static int runSudoCommand() throws Exception {
        String[] trashClean = {"sudo", "rm", "-rf", "~/.Trash/*"};

        Runtime runtime =Runtime.getRuntime();
        Process process = runtime.exec(trashClean);
        OutputStream os = process.getOutputStream();
        os.write((password+"\n").getBytes());
        os.flush();
        os.close();
        process.waitFor();
        String output = readFile(process.getInputStream());
        if (output != null && !output.isEmpty()) {
            System.out.println(output);
        }
        String error = readFile(process.getErrorStream());
        if (error != null && !error.isEmpty()) {
            System.out.println(error);
        }
        return process.exitValue();
    }

    private static String readFile(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                line = bufferedReader.readLine();
            }
            return sb.toString();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }





    /**
     * {casheCleaner/casheCleaner2}
     * User cache makes up the majority of Mac junk on your system.
     * A good user cache cleaning could free up gigabytes
     * of free space and speed up your Mac in the process.
     * Need to close all apps before and reboot system after execute these methods.
     *
     *
     */
    public static void cacheStorageCleaner() {
        Process process = null;
        String[] cacheClean = {"/bin/bash", "-c", "echo " + password + " | sudo rm -rf ~/Library/Caches/*"};
        try {
            process = Runtime.getRuntime().exec(cacheClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }

    public static void cacheStorageCleaner2() {
        Process process = null;
        String[] cacheClean = {"/bin/bash", "-c", "echo " + password + " | sudo rm -rf /Library/Caches/*"};
        try {
            process = Runtime.getRuntime().exec(cacheClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }

    /**
     * {cacheDNSCleaner}
     * DNS cache is old cache entries that translate internet domain  names
     * (example.com) into IP addresses on your Mac. Clear DNS cache regularly to make sure all websites work correctly.
     *
     */
    public static void cacheDNSCleaner () {
        Process process = null;
        String[] cacheClean = {"/bin/bash", "-c", "echo " + password + " | sudo dscacheutil -flushcache;sudo killall " +
                "-HUP mDNSResponder;say cache flushed"};
        try {
            process = Runtime.getRuntime().exec(cacheClean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }

    public static void getAppsList (String filePath){
        Process process = null;
        String[] listAppsCom = {"/bin/bash", "-c", "system_profiler -detailLevel full SPApplicationsDataType -xml >" + filePath};
                try {
            process = Runtime.getRuntime().exec(listAppsCom);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }
        /*//Features
        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            while ((appsListTemp = output.readLine()) != null) {
                appsList+=appsListTemp;
                FileWriter out = new FileWriter(filePath);
                out.write(appsList);
                out.close();
                System.out.println(appsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    //String[] listAppsCommandTest = {"/bin/bash", "-c", "echo " + password + " | sudo find / -iname *.app"};
    */


    public static void removeApplication (String appPath){
        Process process = null;
        String[] rmAppCommand = {"/bin/bash", "-c", "echo " + password + " | sudo rm -rf " + appPath};
        try {
            process = Runtime.getRuntime().exec(rmAppCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.destroy();
    }
}

