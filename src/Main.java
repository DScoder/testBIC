import java.io.IOException;

/**
 * Created by DScoder on 27.05.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String path = "src\\resources\\lng.csv";

        CVSHandler cvsHandler = new CVSHandler();
        cvsHandler.readCVS(path);

        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + ") " + cvsHandler.getCsvData().get(i));
        }

    }
}
