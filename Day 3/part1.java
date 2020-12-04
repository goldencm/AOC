import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> tobMap = loadBuffer();
        int treeCount = 0;
        for(int i = 0; i < tobMap.size(); i++) {
            if ((tobMap.get(i)).charAt((i * 3) % 31) == '#')
                treeCount++;
        }
        System.out.println(treeCount);
    }
    
    private static ArrayList<String> loadBuffer() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.txt"); 
        Scanner sc = new Scanner(file); 
        ArrayList<String> tempList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            tempList.add(sc.next());
        }
        sc.close();
        return tempList;
    }
}
