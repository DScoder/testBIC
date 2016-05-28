import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by DScoder on 27.05.2016.
 */
public class CSVHandler {

    private List<String[]> csvData = new ArrayList<>();
    private String csvSplitBy = ";";
    
    private ArrayList<String[]> group;
    private ArrayList<ArrayList<String[]>> groups;
    private int checkedGroup;
    long start;

    public void readCVS(String path){
        start = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path)))){
            String line;
            String[] lines;
            while ((line = reader.readLine()) != null) {
                lines = line.split(csvSplitBy);
                csvData.add(lines);
            }
            System.out.println("Create csvData: " + ( System.currentTimeMillis() - start ) + " ms");
        } catch (IOException e) {
            System.out.println("Not found file or can't read.");
        }
    }

    public void groupCSVData(){
        groups = new ArrayList<>();
        Iterator<String[]> itr = csvData.listIterator();
        group = new ArrayList<>();
        group.add(itr.next());
        groups.add(group);

        start = System.currentTimeMillis();
        String[] str;
        while (itr.hasNext()) {
            str = itr.next();
            if (checkData(str)){
                groups.get(checkedGroup).add(str);
            } else {
                group = new ArrayList<>();
                group.add(str);
                groups.add(group);
            }
        }
        System.out.println("Grouping of " + csvData.size() + " records ready in: " + ( System.currentTimeMillis() - start ) + " ms");
    }

    private boolean checkData(String[] str){
        for (int i = 0; i < groups.size(); i++) {
            checkedGroup = i;
            for (int j = 0; j < groups.get(i).size(); j++) {
                for (int l = 0; l < str.length; l++) {
                    if (!str[l].equals("\"\"") && groups.get(i).get(j)[l].equals(str[l]) )
                        return true;
                }
            }
        }
        return false;
    }

    public void groupInfo(){
        System.out.println("\nGroups info:");
        System.out.println("Groups size: " + groups.size());
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).size() > 1){
                System.out.println("Group number " + i+1 + " have "+ groups.get(i).size() + " same results:");
                for (int j = 0; j < groups.get(i).size(); j++) {
                   System.out.println(groups.get(i).get(j)[0] + groups.get(i).get(j)[1] + groups.get(i).get(j)[2]);
                }
            }
        }
    }
}
