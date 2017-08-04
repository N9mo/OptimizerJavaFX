package optimizer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nemo on 22.07.17.
 */
public class Battery {

    private static double energyDesign=17;
    private static double energyWhenFull=0;
    private static double energyCurrent=0;
    private static double energyCycle=0;
    private static double energyDecayed=0;

    public double getEnergyDesign() {
        return energyDesign;
    }

    public double getEnergyWhenFull() {
        return energyWhenFull;
    }

    public double getEnergyCurrent() {
        return energyCurrent;
    }

    public double getEnergyCycle() {
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

    public void setEnergyCycle(double energyCycle) {
        this.energyCycle = energyCycle;
    }

    public void setEnergyDecayed(double energyDecayed) {
        this.energyDecayed = energyDecayed;
    }
}
