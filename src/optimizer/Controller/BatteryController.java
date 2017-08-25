package optimizer.Controller;

import optimizer.model.Battery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by nemo on 22.07.17.
 */
public class BatteryController {

    private Battery bat = new Battery();

    public void setBat(){
        initBatt(getBattInfo());
    }

        //get raw String with batt info


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
                //System.out.println(outputStringTemp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return battInfo;
    }

    public void initBatt(String battInfo) {
        String[] array = battInfo.split("; Cap=");
        String[] array2 = array[1].split(": FCC=");
        bat.setEnergyCurrent(Double.parseDouble(array2[0]));
        System.out.println("Energy Current: " + bat.getEnergyCurrent() + " mAh");//Test

        String[] array3 = array2[1].split("; Design=");
        bat.setEnergyWhenFull(Double.parseDouble(array3[0]));
        System.out.println("Energy When Full: " + bat.getEnergyWhenFull() + " mAh");//Test

        String[] array4 = array3[1].split("; Time=");
        bat.setEnergyDesign((Double.parseDouble(array4[0])));
        System.out.println("Energy Design: " + bat.getEnergyDesign() + " mAh");//Test

        String[] array5 = array4[1].split("; Cycles=");
        String[] array6 = array5[1].split("; Location=");
        bat.setEnergyCycle(Double.parseDouble(array6[0]));
        System.out.println("Energy Cycle: " + bat.getEnergyCycle());//Test

        bat.setEnergyDecayed((double) ((bat.getEnergyWhenFull()/bat.getEnergyDesign() - 1) * 100));
    }



    /*public HashMap<String, Double> showBatInfoTest(){
        HashMap <String , Double > map = new HashMap<>();
        map.put("EnergyCurrent", bat.getEnergyCurrent());
        map.put("EnergyWhenFull", bat.getEnergyWhenFull());
        map.put("EnergyDesign", bat.getEnergyDesign());
        map.put("EnergyCycle", bat.getEnergyCycle());
        map.put("EnergyDecayed", bat.getEnergyDecayed());
        System.out.println(map);

        return map;
    }*/


    public void initBatTest() {
        bat.setEnergyCurrent(3200);
        bat.setEnergyWhenFull(3800);
        bat.setEnergyDesign(4000);
        bat.setEnergyCycle(150);
        bat.setEnergyDecayed((((1.0 - Double.valueOf(bat.getEnergyWhenFull())/Double.valueOf(bat.getEnergyDesign()) ) * 100)));
        System.out.println(((((double)(1 -(bat.getEnergyWhenFull()/bat.getEnergyDesign() ))))));


    }
}



