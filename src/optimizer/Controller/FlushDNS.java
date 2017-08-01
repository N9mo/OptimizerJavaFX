package optimizer.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by vergarja on 3/12/17.
 */

//public long getTotalSpace();

public class FlushDNS {

    public static void runSystemCommand(String command) {
        int count = 0,x=0;

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            while (count==0 && (s = inputStream.readLine()) != null) {
                System.out.println(s);
                ++count;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /*public static void main(String[] args) {

        runSystemCommand("sudo discoveryutil mdnsflushcache;sudo discoveryutil udnsflushcaches;say flushed");
    }*/
}