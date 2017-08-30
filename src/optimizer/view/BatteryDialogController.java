package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import optimizer.Controller.BatteryController;
import optimizer.model.Battery;


public class BatteryDialogController {

    @FXML
    private com.gluonhq.charm.glisten.control.ProgressBar energyDesigneBar;
    @FXML
    private com.gluonhq.charm.glisten.control.ProgressBar energyWhenFullBar;
    @FXML
    private com.gluonhq.charm.glisten.control.ProgressBar energyCurrentBar;
    @FXML
    private Text energyDesignValue;
    @FXML
    private Text  energyWhenFullValue;
    @FXML
    private Text  energyCurrentValue;
    @FXML
    private Text  energyCycleValue;
    @FXML
    private Text  energyDecayedValue;


    /**
     * Initializes the controller class. This method is called automatically
     * after the fxml is loaded.
     */
    @FXML
    private void initialize() {
        Battery bat = new Battery();
        BatteryController batteryController = new BatteryController();

        batteryController.initBatt(batteryController.getBattInfo());

        energyDesignValue.setText((int)bat.getEnergyDesign() + " mAh");
        energyWhenFullValue.setText((int)bat.getEnergyWhenFull() + " mAh");
        energyCurrentValue.setText((int)bat.getEnergyCurrent() + " mAh");
        energyCycleValue.setText(bat.getEnergyCycle() + " cycles");
        energyDecayedValue.setText((int)bat.getEnergyDecayed() + " %");

        energyDesigneBar.setProgress(bat.getEnergyDesign());
        energyWhenFullBar.setProgress(bat.getEnergyWhenFull()/bat.getEnergyDesign());
        energyCurrentBar.setProgress(bat.getEnergyCurrent()/bat.getEnergyDesign());
    }

    /**
     * Call then user click Got it button.
     */
    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
