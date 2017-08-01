package optimizer.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by vergarja on 3/12/17.
 */

//public long getTotalSpace();

public class PingIt {

    public static void runSystemCommand(String command) {
        int count = 0,x=0;

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            while (count==0 && (s = inputStream.readLine()) != null) {
                System.out.println("Website is up and running.");
                ++count;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void run (String[] args) {
        int count, len = 0;
        System.out.println("What is the website you want to check?");
        Scanner PingIt = new Scanner(System.in);
        String website;
        website = PingIt.next();
        String ip = website;
        //Length Lengthobject = new Length();
        //len=Lengthobject.main(website);

        runSystemCommand("Ping " + ip);
    }
}