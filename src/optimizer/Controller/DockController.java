package optimizer.Controller;

import java.io.IOException;

public class DockController {

    public static void dockKill () {
        try {

            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec("killall Dock");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Dock Reset"); //Test. возможно вывод сообщения в окно
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}