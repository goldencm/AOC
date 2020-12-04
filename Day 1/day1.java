import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {
    public static void main(String args[]) throws Exception {
        ArrayList<Integer> intList = loadBuffer();
        Collections.sort(intList);
        comparoratorPart2(intList);
    }


    private static void comparoratorPart1(ArrayList<Integer> intList) {
        for(int i = 0; i < intList.size() / 2; i++) {
            if (intList.indexOf(2020 - intList.get(i)) != -1) {
                System.out.println((2020 - intList.get(i)) * intList.get(i));
                break;
            }
        }
    }

    private static void comparoratorPart2(ArrayList<Integer> intList) {
        for(int i = 0; i < intList.size(); i++) {
            for (int x = i + 1; x < intList.size(); x++) {
                if (intList.indexOf(2020 - (intList.get(i) + intList.get(x))) != -1) {
                    System.out.println((2020 - (intList.get(i) + intList.get(x))) * intList.get(i) * intList.get(x));
                    break;
                }
            }
        }
    }


    private static ArrayList<Integer> loadBuffer() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.txt"); 
        Scanner sc = new Scanner(file); 
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (sc.hasNextLine()) {
            tempList.add(sc.nextInt());
        }
        sc.close();
        return tempList;
    }
}
