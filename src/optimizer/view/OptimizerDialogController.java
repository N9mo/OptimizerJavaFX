package optimizer.view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import optimizer.Controller.OptimizerController;
import optimizer.model.Account;

public class OptimizerDialogController {

    Account account;


    public void memoryCashClean(ActionEvent actionEvent) { OptimizerController.cachedMemoryCleaner();
    }

    public void storageCashClean(ActionEvent actionEvent) {
        OptimizerController.cacheStorageCleaner();
        OptimizerController.cacheStorageCleaner2();
    }

    public void dnsCashClean(ActionEvent actionEvent) { OptimizerController.cacheDNSCleaner();
    }

    public void trashClean(ActionEvent actionEvent) {
        try {
            OptimizerController.runSudoCommand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
