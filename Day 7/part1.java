import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class part1 {
    private static String[] nullString = {"no other"};
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String[]> bufferMap = formatBuffertoMap(loadBuffer());
        System.out.println("Total: " + (traversalCounter(bufferMap, 0, "shiny gold") - 1));
    }

    public static int traversalCounter(Map<String, String[]> bufferMap, int counter, String key) {
        String[] values;
        int total = 1;
        Iterator<Map.Entry<String, String[]>> itr = bufferMap.entrySet().iterator();  
        while (itr.hasNext()) {
            Map.Entry<String, String[]> entry = itr.next(); 
            values = entry.getValue();
            for(int i = 0; i < values.length; i++) {
                if((values[i].substring(2)).equals(key)) {
                    bufferMap.replace(entry.getKey(), nullString);
                    System.out.println(values[i].substring(2) + " : " + entry.getKey() + "\t " + total);
                    total += traversalCounter(bufferMap, counter, entry.getKey());
                }
            }
        }
        return total;
    }

    public static Map<String, String[]> formatBuffertoMap(ArrayList<String> buffer) {
        ArrayList<String> temp = buffer;
        Map<String, String[]> myMap = new HashMap<String, String[]>();
        for(int i = 0; i < temp.size(); i++) { 
            myMap.put(temp.get(i).split("contain ")[0].split(" bags")[0], 
                            (temp.get(i).split("contain "))[1].split(" bags, | bag, | bags.| bag."));
        }
        return myMap;
    }
    
    private static ArrayList<String> loadBuffer() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.txt"); 
        Scanner sc = new Scanner(file); 
        sc.useDelimiter("\r\n");
        ArrayList<String> tempList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            tempList.add(sc.next());
        }
        sc.close();
        return tempList;
    }
}
