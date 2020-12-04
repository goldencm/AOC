import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> tobMap = loadBuffer();
        // long totalTrees = treeCounter(tobMap, 1, 1);
        // totalTrees *= treeCounter(tobMap, 3, 1);
        // totalTrees *= treeCounter(tobMap, 5, 1);
        // totalTrees *= treeCounter(tobMap, 7, 1);
        // totalTrees *= treeCounter(tobMap, 1, 2);
        // System.out.println(totalTrees);
        System.out.println(treeCounter(tobMap, 1, 1));
        System.out.println(treeCounter(tobMap, 3, 1));
        System.out.println(treeCounter(tobMap, 5, 1));
        System.out.println(treeCounter(tobMap, 7, 1));
        System.out.println(treeCounter(tobMap, 1, 2));
        
    }
    

    private static int treeCounter(ArrayList<String> tobMap, int right, int down) {
        int treeCount = 0;
        for(int i = 0; i < tobMap.size(); i += down ) {
            if ((tobMap.get(i)).charAt((i * right) % 31) == '#')
                treeCount++;
        }
        return treeCount;
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

