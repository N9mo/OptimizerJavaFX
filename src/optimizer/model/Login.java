package optimizer.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login {

    public void display() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setHeight(300);
        window.setWidth(300);
        Text auth = new Text();
        auth.setTranslateY(40);
        auth.setTranslateX(100);
        auth.getStyleClass().add("auth");
        TextField username = new TextField();
        username.setTranslateY(70);
        username.setTranslateX(75);
        PasswordField password = new PasswordField();
        password.setTranslateY(100);
        password.setTranslateX(75);
        Button loginBtn = new Button();
        loginBtn.getStyleClass().add("loginBtn");
        loginBtn.setStyle("-fx-cursor: hand");
        loginBtn.setMinHeight(50);
        loginBtn.setMinWidth(100);
        loginBtn.setTranslateX(115);
        loginBtn.setTranslateY(155);

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().equals("") && password.getText().equals("")) {
                    window.close();
                } else {
                    System.out.println("Error");
                }
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(username, password, loginBtn);
        Scene scene = new Scene(layout);
        layout.getStylesheets().add(this.getClass().getResource("/optimizer/view/dark.css").toExternalForm());

        username.setFocusTraversable(false);
        password.setFocusTraversable(false);

        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }
}