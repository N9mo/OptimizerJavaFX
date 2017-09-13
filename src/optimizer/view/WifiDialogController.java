package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import optimizer.Controller.WiFiController;
import optimizer.model.Account;


public class WifiDialogController {

    @FXML
    private ProgressBar modemWFProgrProgress;

    @FXML
    private ProgressBar ispWFProgrProgress;

    @FXML
    private ProgressBar serverWFProgrProgress;

    @FXML
    private Label modemWFProgrLabel;

    @FXML
    private Label ispWFProgrLabel;

    @FXML
    private Label serverWFProgrLabel;





    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }

    public void  fixWiFi(ActionEvent actionEvent) {

        int[] result = WiFiController.run(Account.getPassword());

        if (result[0] == 0) {
            modemWFProgrProgress.setProgress(1);
            modemWFProgrLabel.setText("Success!");
            modemWFProgrLabel.setTextFill(Color.GREEN);
        }
        else {
            modemWFProgrProgress.setProgress(0);
            modemWFProgrLabel.setText("Packets lost");
            modemWFProgrLabel.setTextFill(Color.RED);
        }

        if (result[1] == 0) {
            ispWFProgrProgress.setProgress(1);
            ispWFProgrLabel.setText("Success!");
            ispWFProgrLabel.setTextFill(Color.GREEN);
        }
        else {
            ispWFProgrProgress.setProgress(0);
            ispWFProgrLabel.setText("Packets lost");
            ispWFProgrLabel.setTextFill(Color.RED);
        }

        if (result[2]==0) {
            serverWFProgrProgress.setProgress(1);
            serverWFProgrLabel.setText("Success!");
            serverWFProgrLabel.setTextFill(Color.GREEN);
        }
        else {
            serverWFProgrProgress.setProgress(0);
            serverWFProgrLabel.setText("Packets lost");
            serverWFProgrLabel.setTextFill(Color.RED);
        }
    }
}
