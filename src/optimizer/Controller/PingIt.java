package optimizer.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingIt {

    public static String runSystemCommand(String site) {
        int count = 0,x=0;
        String command = "ping " + site;
        String result=null;
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String s = "";
            // reading output stream of the command
            if (count==0 && (s = inputStream.readLine()) != null) {
                //System.out.println("Website is up and running.");
                result ="Website is up and running.";
                ++count;
            }
            else{
                //System.out.println("ERROR");
                result ="ERROR";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}