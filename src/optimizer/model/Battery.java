package optimizer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nemo on 22.07.17.
 */
public class Battery {

    private static double energyDesign;
    private static double energyWhenFull;
    private static double energyCurrent;
    private static String energyCycle;
    private static double energyDecayed;

    public double getEnergyDesign() {
        return energyDesign;
    }

    public double getEnergyWhenFull() {
        return energyWhenFull;
    }

    public double getEnergyCurrent() {
        return energyCurrent;
    }

    public String getEnergyCycle() {
        return energyCycle;
    }

    public double getEnergyDecayed() {
        return energyDecayed;
    }

    public void setEnergyDesign(double energyDesign) {
        this.energyDesign = energyDesign;
    }

    public void setEnergyWhenFull(double energyWhenFull) {
        this.energyWhenFull = energyWhenFull;
    }

    public void setEnergyCurrent(double energyCurrent) {
        this.energyCurrent = energyCurrent;
    }

    public void setEnergyCycle(String energyCycle) {
        this.energyCycle = energyCycle;
    }

    public void setEnergyDecayed(double energyDecayed) {
        this.energyDecayed = energyDecayed;
    }
}
