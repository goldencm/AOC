import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> buffer = loadBuffer();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        int accumulator = 0;
        String instruction;
        int value = 0;
        for(int i = 0; i < buffer.size(); i++) {
            if (visited.contains(i))
                break;
            visited.add(i);
            instruction = buffer.get(i).split(" ")[0];
            value = Integer.parseInt(buffer.get(i).split(" ")[1]);
            if(instruction.equals("acc")) {  
                accumulator += value;
            } else if (instruction.equals("jmp")) {
                i += value - 1;
            }
            
        }
        System.out.println(accumulator);
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
