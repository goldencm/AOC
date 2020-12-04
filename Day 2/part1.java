import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> fileBuffer = loadBuffer();

        int[] passwordMin = new int[(fileBuffer.size() / 3)];
        int[] passwordMax = new int[(fileBuffer.size() / 3)];
        char[] passwordChar = new char[(fileBuffer.size() / 3)];
        String[] passwordArr = new String[(fileBuffer.size() / 3)];
        String[] passwordMinMaxBuffer;

        for(int i = 0; i < fileBuffer.size(); i++) {
            if (i % 3 == 0) {
                passwordMinMaxBuffer = (fileBuffer.get(i)).split("-");
                passwordMin[i / 3] = Integer.parseInt(passwordMinMaxBuffer[0]);
                passwordMax[i / 3] = Integer.parseInt(passwordMinMaxBuffer[1]);
            } else if (i % 3 == 1) {
                passwordChar[i / 3] = (fileBuffer.get(i)).charAt(0);
            } else {
                passwordArr[i / 3] = fileBuffer.get(i);
            }
        }

        int validcount = 0;
        for (int i = 0; i < passwordMin.length; i++) {
            validcount += isValid(passwordMin[i], passwordMax[i], passwordChar[i], passwordArr[i]);
        }

        System.out.println(validcount);
    }

    
    private static int isValid(int min, int max, char c, String password) {
        int count = 0;
        for(int i = 0; i < password.length(); i++) {
            if (c == password.charAt(i))
                count++;
        }
        return (count >= min && count <= max) ? 1 : 0; 
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

