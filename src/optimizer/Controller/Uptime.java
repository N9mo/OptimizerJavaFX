package optimizer.Controller;

import java.io.IOException;

/**
 * Created by vergarja on 4/30/17.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by vergarja on 3/12/17.
 */

//public long getTotalSpace();

public class Uptime {

    public static void runSystemCommand(String command) {
        int count = 0;

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            while (count==0 && (s = inputStream.readLine()) != null) {
                System.out.println(s);
                System.out.println("If your computer has been on for more than 5 days you should restart your computer.");
                ++count;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void run(String[] args) {
        //System.out.println("What is the website you want to check?");
        //Scanner WebsiteCheckController = new Scanner(System.in);
        //String website;
        //website = WebsiteCheckController.next();
        //String ip = website;


        runSystemCommand("uptime");
    }
}