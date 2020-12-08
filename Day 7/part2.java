import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String[]> bufferMap = formatBuffertoMap(loadBuffer());
        System.out.println("Total: " + (inTraversalCounter(bufferMap, 1, "shiny gold")));
    }

    public static int inTraversalCounter(Map<String, String[]> bufferMap, int multiplier, String key) {
        String[] values = bufferMap.get(key);
        int total = 0;
        int numBags = 0;
        for(int i = 0; i < values.length; i++) {
            try {
                numBags = Integer.parseInt(values[i].substring(0, 1));
                total += (multiplier * numBags) + inTraversalCounter(bufferMap, (multiplier * numBags), values[i].substring(2));
            } catch (NumberFormatException e) {
                return 0;
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
