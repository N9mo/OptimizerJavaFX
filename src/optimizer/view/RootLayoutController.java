package optimizer.view;


import eu.hansolo.medusa.*;

import eu.hansolo.medusa.skins.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Pair;
import optimizer.Controller.BatteryController;
import optimizer.Controller.StorageController;
import optimizer.Main;
import optimizer.model.Battery;

import java.io.IOException;
import java.util.HashMap;


public class RootLayoutController {

    // Ссылка на главное приложение.
    private Main mainApp;



    @FXML
    private Text battDescriptionProcess;
    @FXML
    private Pane batStatPane;
    @FXML
    private Pane storCapPane;
    @FXML
    private com.gluonhq.charm.glisten.control.ProgressBar progressBar;

    @FXML
    private Button bateryButton;
    @FXML
    private Text textArea2;
    @FXML
    private Text textArea3;
    @FXML
    private TextField textFieldBatteryArea;
    @FXML
    protected GridPane gridPane;
    @FXML
    private Button optimizerButton;
    @FXML
    private Text storage1Label;
    @FXML
    private Text storage2Label;


    Gauge gauge1;
    Gauge gauge2;

    HashMap <Integer, Pair<String, Pair<Long,Long>>> resulStorageMap1;

    /*public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    *//**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param
     *//*
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }*/

    @FXML
    private void initialize() {
//
        Gauge batteryGauge = new Gauge();
        batteryGauge.setMaxSize(170,170);
        //gauge.setMinValue(0);
        //gauge.setMaxValue(100);
        //gauge.setValue(75);
        batteryGauge.setSkin(new FlatSkin(batteryGauge));
        //gauge.setAutoScale(true);
        batteryGauge.setAnimated(true);
        batteryGauge.setAnimationDuration(10000);
        batteryGauge.setTitle("");
        batteryGauge.setUnit("%");
        batteryGauge.setUnitColor(Color.GRAY);
        batteryGauge.setDecimals(0);
        batteryGauge.setBarBackgroundColor(Color.rgb(229, 237, 255));
        batteryGauge.setValueColor(Color.GRAY);
        batteryGauge.setTitleColor(Color.DARKRED);
        batteryGauge.setSubTitleColor(Color.WHITE);
        batteryGauge.setBarBorderColor(Color.GREEN);
        batteryGauge.setBarColor(Color.rgb(44, 101, 189));
        batteryGauge.setNeedleColor(Color.WHITE);
        batteryGauge.setThresholdColor(Color.rgb(204, 0, 0));
        batteryGauge.setTickLabelColor(Color.rgb(151, 151, 151));
        batteryGauge.setTickMarkColor(Color.GRAY);
        batteryGauge.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);
        batteryGauge.setDisable(false);
        batteryGauge.setSectionsVisible(true);
        //gauge.setSections(new Section(74, 100, Color.ORANGE));
        //gauge.addSection(new Section(74, 75, Color.ORANGE));
        batteryGauge.setAreasVisible(true);
        batteryGauge.setAreas(new Section(75, 100, Color.RED));

        batteryGauge.relocate(230,80);
        batStatPane.getChildren().addAll(batteryGauge);

        Battery bat = new Battery();
        BatteryController batteryController = new BatteryController();

        //batteryController.initBatt(batteryController.getBattInfo()); //add for Mac
        batteryController.initBatTest();                               //test

        batteryGauge.setValue(bat.getEnergyCurrent()/bat.getEnergyDesign()*100);

        gauge1 = new Gauge();
        gauge1.setMaxSize(170,170);
        gauge1.setMinValue(0);
        gauge1.setMaxValue(100);
        gauge1.setValue(90);
        gauge1.setSkin(new FlatSkin(gauge1));
        //gauge1.setAutoScale(true);
        gauge1.setAnimated(true);
        gauge1.setAnimationDuration(10000);
        gauge1.setTitle("");
        gauge1.setUnit("MB used");
        gauge1.setUnitColor(Color.GRAY);
        gauge1.setDecimals(0);
        gauge1.setBarBackgroundColor(Color.rgb(229, 237, 255));
        gauge1.setValueColor(Color.GRAY);
        gauge1.setTitleColor(Color.DARKRED);
        gauge1.setSubTitleColor(Color.WHITE);
        gauge1.setBarBorderColor(Color.GREEN);
        gauge1.setBarColor(Color.rgb(44, 101, 189));
        gauge1.setNeedleColor(Color.WHITE);
        gauge1.setThresholdColor(Color.rgb(204, 0, 0));
        gauge1.setTickLabelColor(Color.rgb(151, 151, 151));
        gauge1.setTickMarkColor(Color.BLACK);
        gauge1.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);

        gauge2 = new Gauge();
        gauge2.setMaxSize(170,170);
        gauge2.setMinValue(0);
        gauge2.setMaxValue(100);
        gauge2.setValue(45);
        gauge2.setSkin(new FlatSkin(gauge2));
        //gauge2.setAutoScale(true);
        gauge2.setAnimated(true);
        gauge2.setAnimationDuration(10000L);
        gauge2.setTitle("");
        gauge2.setUnit("MB used");
        gauge2.setUnitColor(Color.GRAY);
        gauge2.setDecimals(0);
        gauge2.setBarBackgroundColor(Color.rgb(229, 237, 255));
        gauge2.setValueColor(Color.GRAY);
        gauge2.setTitleColor(Color.DARKRED);
        gauge2.setSubTitleColor(Color.WHITE);
        gauge2.setBarBorderColor(Color.GREEN);
        gauge2.setBarBackgroundColor(Color.GRAY);
        gauge2.setBarColor(Color.rgb(44, 101, 189));
        gauge2.setNeedleColor(Color.WHITE);
        gauge2.setThresholdColor(Color.rgb(204, 0, 0));
        gauge2.setTickLabelColor(Color.rgb(151, 151, 151));
        gauge2.setTickMarkColor(Color.BLACK);
        gauge2.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);
        gauge1.relocate(30,80);
        gauge2.relocate(230,80);
        gauge2.setDisable(true);
        storCapPane.getChildren().addAll(gauge1, gauge2);

        getStorageInfo(null);
    }

    public void openWebSiteDialog(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("webSiteDialog.fxml"));
            stage.setTitle("Website status check");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            gridPane.setEffect(new GaussianBlur());
            stage.show();
/**
 * отменяет блюр основного окна после закрітия batteryDialog * */
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    gridPane.setEffect(null);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFinderDockDialog(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("finderDockDialog.fxml"));
            stage.setTitle("Finder/Dock Fix");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            gridPane.setEffect(new GaussianBlur());
            stage.show();
/**
 * отменяет блюр основного окна после закрітия batteryDialog * */
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    gridPane.setEffect(null);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openBatteryDialog(ActionEvent actionEvent) {
         try {
             gridPane.setEffect(new GaussianBlur());
             Stage stage = new Stage();
             Parent root = FXMLLoader.load(getClass().getResource("batteryDialog.fxml"));
             stage.setTitle("Battery Diagnostic");
             stage.setResizable(false);
             stage.setScene(new Scene(root));
             stage.initModality(Modality.WINDOW_MODAL);
             stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
             stage.show();

             /**
 * отменяет блюр основного окна после закрітия batteryDialog *
 */
             stage.setOnHidden(new EventHandler<WindowEvent>() {
                 @Override
                 public void handle(WindowEvent event) {
                     gridPane.setEffect(null);
                 }
             });

            /*FXMLLoader loader = new FXMLLoader("view/batteryDialog.fxml");
            loader.setLocation(Main.class.getResource("view/batteryDialog.fxml"));
            Pane pane = (Pane) loader.load();

            // Помещаем сведения о батарее в центр корневого макета.
            rootLayout.setCenter(pane);

            // Даём контроллеру доступ к главному приложению.
            BatteryDialogController controller = loader.getController();
            controller.setMainApp(this);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGauge (MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getButton().toString());
        if (mouseEvent.getButton().toString().equals("SECONDARY")) {
            gridPane.setBlendMode(BlendMode.OVERLAY);

            //gridPane.setEffect(null);

        }

        if (mouseEvent.getButton().toString().equals("MIDDLE")) {
            gridPane.setEffect(new GaussianBlur());

            //gridPane.setBlendMode(null);
        }

        if (mouseEvent.getEventType().getName().toString().equals("MOUSE_CLICKED")) {
            //Battery bat = new Battery();
            //bat.initBatt(bat.getBattInfo());
            /*battDescriptionProcess.setText((map.get("EnergyDecayed")).intValue() + " %");

            HashMap<String,Double> map = batteryController.showBatInfoTest();
            batteryGauge.setValue((map.get("EnergyCurrent"))/(map.get("EnergyDesign"))*100);*/

        }


    }

    public void getStorageInfo(ActionEvent actionEvent) {

        try {
            resulStorageMap1 = StorageController.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

            System.out.println(resulStorageMap1.get(1).getKey());
            System.out.println(resulStorageMap1.get(1).getValue().getKey());
            System.out.println(resulStorageMap1.get(1).getValue().getValue());
            gauge1.setValue(resulStorageMap1.get(1).getValue().getValue());
            gauge1.setMaxValue(resulStorageMap1.get(1).getValue().getKey());
            storage1Label.setText(resulStorageMap1.get(1).getKey());

            if (resulStorageMap1.size()!=0) {
                System.out.println(resulStorageMap1.get(2).getKey());
                System.out.println(resulStorageMap1.get(2).getValue().getKey());
                System.out.println(resulStorageMap1.get(2).getValue().getValue());
                gauge2.setValue(resulStorageMap1.get(2).getValue().getValue());
                gauge2.setMaxValue(resulStorageMap1.get(2).getValue().getKey());
                gauge2.setDisable(false);
                storage2Label.setText(resulStorageMap1.get(2).getKey());
            }

    }
}
