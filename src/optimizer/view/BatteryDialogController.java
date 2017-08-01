package optimizer.view;

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

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
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
    public void setBattery() {

        BatteryController batteryController = new BatteryController();
        batteryController.setBatTest();
        batteryController.getBatInfoTest();
        HashMap <String,Integer> map = batteryController.getBatInfoTest();

        energyDesign.setText(String.valueOf("EnergyDesign: " + map.get("EnergyDesign")));
        energyWhenFull.setText( String.valueOf("EnergyWhenFull: " + map.get("EnergyWhenFull")));
        energyCurrent.setText( String.valueOf("EnergyCurrent: " + map.get("EnergyCurrent")));
        energyCycle.setText(String.valueOf("EnergyCycle: " + map.get("EnergyCycle")));
        energyDecayed.setText(String.valueOf("EnergyDecayed: "+map.get("EnergyDecayed")));
    }

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
