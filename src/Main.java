import java.io.IOException;

/**
 * Created by DScoder on 27.05.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String path = "src\\resources\\lng.csv";

        CSVHandler handler = new CSVHandler();
        handler.readCVS(path);
        handler.groupCSVData();

        handler.soutGroup();

    }
}
