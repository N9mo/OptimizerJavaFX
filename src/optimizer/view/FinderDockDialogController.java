package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import optimizer.Controller.DockController;
import optimizer.Controller.FinderController;

public class FinderDockDialogController {

    @FXML
    private Text dockFixText;
    @FXML
    private Text finderFixText;
    @FXML

    public void finderFix(){
        FinderController.finderKill();
        finderFixText.setText("Finder fixed");
    }


    public void dockFix(){
        DockController.dockKill();
        dockFixText.setText("Dock fixed");
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
