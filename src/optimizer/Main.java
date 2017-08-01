package optimizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import optimizer.Controller.BatteryController;
import optimizer.model.Battery;
import optimizer.model.Login;
import optimizer.view.BatteryDialogController;
import optimizer.view.RootLayoutController;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    Login loginWindow = new Login();
    public static Stage windowMain;

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



        //start loginWindow
        windowMain = primaryStage;
        root.setEffect(new GaussianBlur());
        loginWindow.display();
        root.setEffect(null);
        test();


    }

    private  void test(){



        /*Battery bat = new Battery();

        bat.setEnergyDecayed(10);
        System.out.println("EnergyDecayed" + bat.getEnergyDecayed() );
        bat.setEnergyCycle("1000");
        bat.setEnergyCurrent(90);
        bat.setEnergyDesign(110);
        bat.setEnergyWhenFull(100);*/
    }

/*    public void showBatteryPopup() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);

            // Даём контроллеру доступ к главному приложению.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



    public static void main(String[] args) {

        launch(args);
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     */
    public boolean showBatteryDialog() {
        /*try {
            // Загружаем сведения о батарее.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/batteryDialog.fxml"));
            Pane pane = (Pane) loader.load();

            // Помещаем сведения о батарее в центр корневого макета.
            rootLayout.setCenter(pane);

            // Даём контроллеру доступ к главному приложению.
            BatteryDialogController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/batteryDialog.fxml"));
            Pane page = (Pane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("BatteryDialog");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            BatteryDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
