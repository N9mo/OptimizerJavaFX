package optimizer.view;

import com.gluonhq.charm.glisten.control.ProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import optimizer.Controller.BatteryController;
import optimizer.Main;
import optimizer.model.Battery;

import java.util.HashMap;

public class BatteryDialogController {

    private Stage dialogStage;
    private BatteryController batteryController;
    private RootLayoutController rootLayoutController;
    private boolean okClicked = false;

    private Main mainApp;

    @FXML
    private Text energyDesign;
    @FXML
    private Text energyWhenFull;
    @FXML
    private Text energyCurrent;
    @FXML
    private Text energyCycle;
    @FXML
    private Text energyDecayed;
    @FXML
    private GridPane gridPane;
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
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        Battery bat = new Battery();
        BatteryController batteryController = new BatteryController();

        batteryController.initBatt(batteryController.getBattInfo()); //add for Mac

        energyDesignValue.setText((int)bat.getEnergyDesign() + " mAh");
        energyWhenFullValue.setText((int)bat.getEnergyWhenFull() + " mAh");
        energyCurrentValue.setText((int)bat.getEnergyCurrent() + " mAh");
        energyCycleValue.setText((int)bat.getEnergyCycle() + " cycles");
        energyDecayedValue.setText((int)bat.getEnergyDecayed() + " %");

        energyDesigneBar.setProgress(bat.getEnergyDesign());
        energyWhenFullBar.setProgress(bat.getEnergyWhenFull()/bat.getEnergyDesign());
        energyCurrentBar.setProgress(bat.getEnergyCurrent()/bat.getEnergyDesign());
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    /**
     * Задаёт  информацию о батарее.
     *
     * @param battery
     */


    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
            okClicked = true;
            dialogStage.close();
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


  /*  public void showBatInfo() {

        BatteryController batteryController = new BatteryController();
        batteryController.initBatTest();
        batteryController.showBatInfoTest();
        HashMap <String,Double> map = batteryController.showBatInfoTest();

        energyDesignValue.setText(String.valueOf(map.get("EnergyDesign")));
        energyWhenFullValue.setText(String.valueOf(map.get("EnergyWhenFull")));
        energyCurrentValue.setText(String.valueOf(map.get("EnergyCurrent")));
        energyCycleValue.setText(String.valueOf(map.get("EnergyCycle" )));
        energyDecayedValue.setText(String.valueOf(map.get("EnergyDecayed")));
    }*/

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
        //RootLayoutController rootLayoutController = new RootLayoutController();
        //rootLayoutController.getGridPane().setEffect(null);
        //gridPane.setEffect(null);
    }

}
