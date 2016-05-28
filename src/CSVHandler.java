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
    private LinkedList<String[]> csvDataLinked;

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
        start = System.currentTimeMillis();
        csvDataLinked = new LinkedList<>();
        csvDataLinked.addAll(csvData);
        groups = new ArrayList<>();
        System.out.println("Copy ArrayList to LinkedList : " + ( System.currentTimeMillis() - start ) + " ms");

        start = System.currentTimeMillis();
        ListIterator<String[]> itr;
        String[] str;
        if (!csvData.isEmpty()){
            while (!csvDataLinked.isEmpty()){
                group = new ArrayList<>();
                itr = csvDataLinked.listIterator(0);
                while (itr.hasNext()) {
                    str = itr.next();
                    if (group.isEmpty() || checkData(str)){
                        group.add(str);
                        itr.remove();
                    }
                }
                groups.add(group);
            }
        }
        System.out.println("Group ready in : " + ( System.currentTimeMillis() - start ) + " ms");
    }
    

    private boolean checkData(String[] str){
            for (int j = 0; j < group.size(); j++) {
                for (int k = 0; k < group.get(j).length; k++) {
                    for (int l = 0; l < str.length; l++) {
                        if (!str[l].equals("\"\"") && group.get(j)[l].equals(str[l]) ){
                            return true;
                        }
                    }
                }
            }
        return false;
    }

    public void soutGroup(){
//        for (int i = 0; i < groups.size(); i++) {
//            System.out.println(i+1 + ") " + groups.get(i).size() );
//        }
        int i = 3;
        System.out.println(groups.size() + groups.get(i).get(0)[0] + groups.get(i).get(0)[1] + groups.get(i).get(0)[2]);
    }


    public List<String[]> getCsvDataLinked() {
        return csvDataLinked;
    }
}
