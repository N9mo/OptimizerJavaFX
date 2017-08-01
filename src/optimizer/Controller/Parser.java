package optimizer.Controller;

/**
 * Created by nemo on 24.05.17.
 */
public class Parser {

    public static double parseOutVmstatCommand (String out){
        double fileBackedPages;

        String [] array = out.split("File-backed pages:");
        String [] array2 = array[1].split("Anonymous pages:");
        fileBackedPages = Double.parseDouble(array2[0]);

        return fileBackedPages;
    }
}
