import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;


public class part1 {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> data = loadBuffer();
        int totalPassports = 0;
        for (int i = 0; i < data.size(); i++) {
            totalPassports += passportChecker(data.get(i));
        }
        System.out.println(totalPassports);
    }

    private static int passportChecker(String buffer) {
        String[] splitBuffer = buffer.split(" |\r\n");
        String[] passportFields = {"byr", "iyr", "eyr", "hgt", "ecl", "pid", "hcl"};
        boolean qualified = true;
        for(int i = 0; i < passportFields.length; i++) {
            if (qualified) {
                qualified = false;
                for(int x = 0; x < splitBuffer.length; x++) {
                    // System.out.println("Checking: " + splitBuffer[x].substring(0, 3) + " =? " + passportFields[i]);
                    if ((splitBuffer[x].substring(0, 3)).equals(passportFields[i])) {
                        qualified = true;
                        break;
                    }
                        
                }
            } else {
                break;
            }
            
        }
        if (qualified) {
            System.out.print("\n");
            for(int i = 0; i < splitBuffer.length; i++) {
                System.out.print(splitBuffer[i].substring(0, 3) + " ");
            }
            System.out.print("\n");
        }
            
        return qualified? 1 : 0;
    }

    private static ArrayList<String> loadBuffer() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "\\" + "data.txt"); 
        Scanner sc = new Scanner(file); 
        sc.useDelimiter("\r\n\r\n");
        ArrayList<String> tempList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            tempList.add(sc.next());
        }
        sc.close();
        return tempList;
    }
}
