import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class part1 {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> data = loadBuffer();
        ArrayList<String> buffer = new ArrayList<String>();
        String temp;
        int totalPassports = 0;
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i));
            temp = data.get(i);
            if (temp.charAt(0) == '\n') {
                System.out.print("calling");
                totalPassports += formatBuffer(buffer);
                buffer.clear();
            } else {
                buffer.add(temp);
            }
        }
    }

    private static int formatBuffer(ArrayList<String> buffer) {
        ArrayList<String> temp = new ArrayList<String>();;
        for(int i = 0; i < buffer.size(); i++) {
            temp.addAll(Arrays.asList((buffer.get(i)).split(" ")));
        }
        for(int i = 0; i < buffer.size(); i++) {
            System.out.println(buffer.get(i));
        }
        return passportChecker(temp);
    }

    private static int passportChecker(ArrayList<String> buffer) {
        for(int i = 0; i < buffer.size(); i++) {
            System.out.print(buffer.get(i));
        }
        
        
        return 0;
    }

    private static ArrayList<String> loadBuffer() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.txt"); 
        Scanner sc = new Scanner(file); 
        sc.useDelimiter("[;\r]+");
        ArrayList<String> tempList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            tempList.add(sc.next());
        }
        sc.close();
        return tempList;
    }
}
