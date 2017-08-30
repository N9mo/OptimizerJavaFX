package optimizer.Controller;

import optimizer.model.Battery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatteryController {

    private Battery bat = new Battery();

    /**
     * get raw batt info
     */
    public String getBattInfo() {
        Process p = null;
        String outputStringTemp = "";
        String battInfo = "";
        try {
            p = Runtime.getRuntime().exec("pmset -g rawbatt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
        try {
            while ((outputStringTemp = output.readLine()) != null) {
                battInfo += outputStringTemp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return battInfo;
    }

    /**
     * Parse raw batt info and set Battery
     * @param battInfo
     */
    public void initBatt(String battInfo) {
        //String battInfoTest = "jkgk; Cap=1950: FCC=7789; Design=8440; Time=12:10; 69mA; Cycles=290/1000; Location=0;"; //test
        String[] array = battInfo.split("; Cap=");
        String[] array2 = array[1].split(": FCC=");
        bat.setEnergyCurrent(Double.parseDouble(array2[0]));

        String[] array3 = array2[1].split("; Design=");
        bat.setEnergyWhenFull(Double.parseDouble(array3[0]));

        String[] array4 = array3[1].split("; Time=");
        bat.setEnergyDesign((Double.parseDouble(array4[0])));

        String[] array5 = array4[1].split("; Cycles=");
        String[] array6 = array5[1].split("; Location=");
        bat.setEnergyCycle(array6[0]);

        bat.setEnergyDecayed(((bat.getEnergyWhenFull()/bat.getEnergyDesign() - 1) * 100));
    }
}



