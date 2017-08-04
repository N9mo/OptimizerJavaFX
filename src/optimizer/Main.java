package optimizer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

   // public static Stage windowMain;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("view/rootLayout.fxml"));
        primaryStage.setTitle("MemoryController");
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setResizable(false);
        scene.getStylesheets().add("style/dark.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        //show loginWindow
        //windowMain = primaryStage;
        root.setEffect(new GaussianBlur());
        //showLoginWindow();
        root.setEffect(null);
    }

    public void showLoginWindow() throws IOException {
        Stage window = new Stage();
        //window.setTitle("login");
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setHeight(300);
        window.setWidth(300);
        //Text auth = new Text();
        //auth.setTranslateY(40);
        //auth.setTranslateX(100);
        //auth.setText("Authentication");

        //auth.getStyleClass().add("auth");
        TextField username = new TextField();
        //username.setAccessibleText("AccessibleText");
        //username.setAccessibleHelp("AccessibleHelp");
        username.setPromptText("user name");
        username.setStyle("-fx-text-inner-color: gray;");
        //username.setText("setText");


        username.setTranslateY(70);
        username.setTranslateX(65);
        PasswordField password = new PasswordField();
        password.setPromptText("password");
        password.setStyle("-fx-text-inner-color: gray;");
        password.setTranslateY(100);
        password.setTranslateX(65);
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setTextFill(Color.GRAY);
        loginBtn.getStyleClass().add("loginBtn");
        loginBtn.setStyle("-fx-cursor: hand");
        loginBtn.setMinHeight(50);
        loginBtn.setMinWidth(100);
        loginBtn.setTranslateX(100);
        loginBtn.setTranslateY(155);

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().equals("user") && password.getText().equals("admin")) {
                    window.close();
                } else {
                    System.out.println("Error");
                }
            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(username, password, loginBtn);
        Scene scene = new Scene(layout);
        layout.getStylesheets().add(this.getClass().getResource("/style/dark.css").toExternalForm());

        username.setFocusTraversable(false);
        password.setFocusTraversable(false);

        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
