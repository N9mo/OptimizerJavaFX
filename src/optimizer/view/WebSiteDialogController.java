package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import optimizer.Controller.WebsiteCheckController;

public class WebSiteDialogController {
    @FXML
    private TextField webTextField;
    @FXML
    private Label webLabel2;

    public void pingIp(ActionEvent actionEvent) {
        String result = WebsiteCheckController.runSystemCommand(webTextField.getText());
        if (result.equals("Website does not appear to be working")) {
            webLabel2.setTextFill(Color.ORANGE);
        }
        else {
            webLabel2.setTextFill(Color.GREEN);
        }
        webLabel2.setText(result);
    }

    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
        source.setEffect(null);
    }
}
