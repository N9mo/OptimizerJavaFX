package optimizer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nemo on 22.07.17.
 */
public class Battery {

    private static int energyDesign=17;
    private static int energyWhenFull=0;
    private static int energyCurrent=0;
    private static int energyCycle=0;
    private static int energyDecayed=0;

    public int getEnergyDesign() {
        return energyDesign;
    }

    public int getEnergyWhenFull() {
        return energyWhenFull;
    }

    public int getEnergyCurrent() {
        return energyCurrent;
    }

    public int getEnergyCycle() {
        return energyCycle;
    }

    public int getEnergyDecayed() {
        return energyDecayed;
    }

    public void setEnergyDesign(int energyDesign) {
        this.energyDesign = energyDesign;
    }

    public void setEnergyWhenFull(int energyWhenFull) {
        this.energyWhenFull = energyWhenFull;
    }

    public void setEnergyCurrent(int energyCurrent) {
        this.energyCurrent = energyCurrent;
    }

    public void setEnergyCycle(int energyCycle) {
        this.energyCycle = energyCycle;
    }

    public void setEnergyDecayed(int energyDecayed) {
        this.energyDecayed = energyDecayed;
    }
}
