package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import optimizer.Controller.OptimizerController;
import optimizer.model.Account;

public class OptimizerDialogController {


   /* @FXML
    private ProgressBar storageCashCleanProgress;
    @FXML
    private ProgressBar dnsCashCleanProgress;
    @FXML
    private ProgressBar trashCleanProgress;
    @FXML
    private Label trashCleanLabel;
    @FXML
    private Label dnsCashCleanLabel;
    @FXML
    private Label storageCashCleanLabel;*/

    @FXML
    private Label memoryCashCleanLabel;
    @FXML
    private ProgressBar memoryCashCleanProg;

    public void memoryCashClean(ActionEvent actionEvent) {
        Double result = Double.valueOf(OptimizerController.cachedMemoryCleaner(Account.getPassword()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        memoryCashCleanLabel.setText("done");
        memoryCashCleanProg.setProgress(result/100);
    }

    /*public void storageCashClean(ActionEvent actionEvent) {
        OptimizerController.cacheStorageCleaner();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storageCashCleanLabel.setText("done");
        storageCashCleanProgress.setProgress(1);
    }

    public void dnsCashClean(ActionEvent actionEvent) {
        OptimizerController.cacheDNSCleaner(Account.getPassword());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dnsCashCleanLabel.setText("done");
        dnsCashCleanProgress.setProgress(1);
    }

    public void trashClean(ActionEvent actionEvent) {
        try {
            OptimizerController.trashCleaner();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trashCleanLabel.setText("done");
        trashCleanProgress.setProgress(1);
    }
*/
    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
