package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import optimizer.Controller.DockController;
import optimizer.Controller.FinderController;

public class FinderDockDialogController {

    @FXML
    public void finderKill() {
        FinderController.finderKill();
    }

    public void dockKill() {
        DockController.dockKill();
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}


