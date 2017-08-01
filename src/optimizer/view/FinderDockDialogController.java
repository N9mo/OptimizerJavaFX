package optimizer.view;

import javafx.fxml.FXML;
import optimizer.Controller.DockController;
import optimizer.Controller.FinderController;

public class FinderDockDialogController {

    @FXML
    public void run(){
        FinderController.finderKill();
        DockController.dockKill();
    }
}
