import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by DScoder on 27.05.2016.
 */
public class CVSHandler {

    private ArrayList<String> csvData;
    private String cvsSplitBy = ";";

    public void readCVS(String path){
        try {
            csvData = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCsvData() {
        return csvData;
    }
}
