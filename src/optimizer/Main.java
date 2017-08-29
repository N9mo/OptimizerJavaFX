package optimizer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import optimizer.model.Account;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    //private BorderPane rootLayout;

   // public static Stage windowMain;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("view/rootLayout.fxml"));
        primaryStage.setTitle("OptimizerController");
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setResizable(false);
        //scene.getStylesheets().add("style/dark.css");
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

        TextField username = new TextField();
        username.setPromptText("user name");
        username.setStyle("-fx-text-inner-color: gray;");
        username.setTranslateY(70);
        username.setTranslateX(65);
        //username.setFocusTraversable(true);

        PasswordField password = new PasswordField();
        password.setPromptText("password");
        password.setStyle("-fx-text-inner-color: gray;");
        password.setTranslateY(100);
        password.setTranslateX(65);
        //password.setFocusTraversable(true);

        Image duck = new Image("/file/duck-icon.png");
        ImageView ivDuck = new ImageView();
        ivDuck.setImage(duck);
        ivDuck.setFitWidth(50);
        ivDuck.setTranslateY(10);
        ivDuck.setTranslateX(130);
        ivDuck.setPreserveRatio(true);
        ivDuck.setSmooth(true);
       // ivDuck.setCache(true);

        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setTextFill(Color.GRAY);
        loginBtn.getStyleClass().add("loginBtn");
        loginBtn.setStyle("-fx-cursor: hand");
        loginBtn.setMinHeight(50);
        loginBtn.setMinWidth(100);
        loginBtn.setTranslateX(100);
        loginBtn.setTranslateY(155);
        //loginBtn.setDefaultButton(true);

        Button cancelBtn = new Button();
        cancelBtn.setText("Cancel");
        cancelBtn.setTextFill(Color.GRAY);
        cancelBtn.getStyleClass().add("loginBtn");
        cancelBtn.setStyle("-fx-cursor: hand");
        cancelBtn.setMinHeight(30);
        cancelBtn.setMinWidth(100);
        cancelBtn.setTranslateX(100);
        cancelBtn.setTranslateY(220);
        cancelBtn.setCancelButton(true);

        Label loginErrorLabel = new Label();
        loginErrorLabel.setTranslateX(1);
        loginErrorLabel.setTranslateY(260);
        loginErrorLabel.setTextFill(Color.ORANGERED);

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().equals("user") && password.getText().equals("admin")) {
                    Account account = new Account();
                    account.setPassword(password.getText());
                    account.setLogin(username.getText());
                    window.close();
                } else {
                    loginErrorLabel.setText("          Incorrect username or password\n                       Please try again");
                    System.out.println("Error");
                }
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                    window.close();

            }
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(username, password, loginBtn, cancelBtn, ivDuck, loginErrorLabel);
        Scene scene = new Scene(layout);
        layout.getStylesheets().add(this.getClass().getResource("style/dark.css").toExternalForm());

        //username.setFocusTraversable(false);
        //password.setFocusTraversable(false);

        window.setScene(scene);
        window.setAlwaysOnTop(true);
        window.showAndWait();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
