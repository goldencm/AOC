import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {
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
        if (individualAnswers.length == 1)
            return individualAnswers[0].length();
        //ArrayList<Character> charList = new ArrayList<Character>();
        boolean contains = true;
        int total = 0;
        
        for(int y = 0; y < individualAnswers[0].length(); y++) {
            contains = true;
            for(int x = 1; x < individualAnswers.length; x++) {
                if (!individualAnswers[x].contains(Character.toString(individualAnswers[0].charAt(y))))
                    contains = false;
            }
            if (contains)
                total++;
        }
        return total;
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

