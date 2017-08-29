package optimizer.view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import optimizer.Controller.OptimizerController;
import optimizer.model.Account;

public class OptimizerDialogController {

    Account account;


    public void memoryCashClean(ActionEvent actionEvent) {
        OptimizerController.cachedMemoryCleaner(account.getPassword());
        System.out.println("Password" + account.getPassword());
    }

    public void storageCashClean(ActionEvent actionEvent) {
        OptimizerController.cacheStorageCleaner(account.getPassword());
        OptimizerController.cacheStorageCleaner2(account.getPassword());
    }

    public void dnsCashClean(ActionEvent actionEvent) {
        OptimizerController.cacheDNSCleaner(account.getPassword());
    }

    public void trashClean(ActionEvent actionEvent) {
        OptimizerController.trashCleaner(account.getPassword());
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
