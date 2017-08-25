package optimizer.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import optimizer.Controller.PingIt;

public class WebSiteDialogController {
    @FXML
    private TextField webTextField;
    @FXML
    private Label webLabel2;

    public void pingIp(ActionEvent actionEvent) {
        String result = PingIt.runSystemCommand(webTextField.getText());
        if (result.equals("Website does not appear to be working")) {
            webLabel2.setTextFill(Color.ORANGE);
        }
        else {
            webLabel2.setTextFill(Color.GREEN);
        }
        webLabel2.setText(result);
    }
}