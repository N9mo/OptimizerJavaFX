package optimizer.view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class WifiDialogController {

    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
