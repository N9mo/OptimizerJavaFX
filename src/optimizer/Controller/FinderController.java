package optimizer.Controller;

import java.io.IOException;

public class FinderController {

    public static void finderKill () {
        try {

            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec("killall Finder");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finder Reset"); //Test. возможно вывод сообщения в окно
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
