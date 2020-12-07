import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> buffer = loadBuffer();
        int totalYes = 0;
        for(int i = 0 ; i < buffer.size(); i++) {
            totalYes += yesCounter(buffer.get(i));
        }
        System.out.println(totalYes);
    }

    private static int yesCounter(String groupAnswer) {
        String[] individualAnswers = groupAnswer.split("\r\n");
        ArrayList<Character> charList = new ArrayList<Character>();
        for(int x = 0; x < individualAnswers.length; x++) {
            for(int y = 0; y < individualAnswers[x].length(); y++) {
                if (!charList.contains(individualAnswers[x].charAt(y)))
                    charList.add(individualAnswers[x].charAt(y));
            }
        }
        return charList.size();
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

