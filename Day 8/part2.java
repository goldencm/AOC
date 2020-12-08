import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> buffer = loadBuffer();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        int accumulator = 0;
        String instruction;
        int insIndex = indexOfNextInstruction(buffer, 0);
        int value = 0;
        for(int i = 0; i < buffer.size(); i++) {
            if (visited.contains(i)) {
                visited.clear();
                accumulator = 0;
                insIndex = indexOfNextInstruction(buffer, insIndex + 1);
                i = 0;
            }
            visited.add(i);
            instruction = buffer.get(i).split(" ")[0];
            value = Integer.parseInt(buffer.get(i).split(" ")[1]);
            System.out.println(instruction + " : " + value + "| i : " + i);
            if (i == insIndex) {
                if (instruction.equals("jmp"))
                    instruction = "nop";
                else
                    instruction = "jmp";
            }  
            if(instruction.equals("acc")) {  
                accumulator += value;
            } else if (instruction.equals("jmp")) {
                i += value - 1;
            }
            
        }
        System.out.println(accumulator);
    }

    private static int indexOfNextInstruction(ArrayList<String> buffer, int index) {
        String instruction;
        for (int i = index; i < buffer.size(); i++) {
            instruction = buffer.get(i).split(" ")[0];
            if(instruction.equals("jmp") || instruction.equals("nop")) {  
                return i;
            } 
        }
        return 0;
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
