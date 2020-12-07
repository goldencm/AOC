import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        ArrayList<String> buffer = loadBuffer();
        int highestBoardingPass = 0;
        int boardingPass = 0;
        for(int i = 0; i < buffer.size(); i++) {
            boardingPass = calculateSeatID(buffer.get(i));
            //System.out.print("\t | " + boardingPass + '\n');
            if(boardingPass > highestBoardingPass)
                highestBoardingPass = boardingPass;
        }
        System.out.println(highestBoardingPass);
    }

    private static int calculateSeatID(String buffer) {
        //System.out.print(buffer + " : \n");
        return findRow(buffer.substring(0, 7)) * 8 + findColumn(buffer.substring(7, 10));
    }
    private static int findRow(String rowString) {
        int maxRow = 128;
        int minRow = 0;
        for(int i = 0; i < rowString.length(); i++) {
            //System.out.print(rowString.charAt(i) + " || ");
            if(rowString.charAt(i) == 'F') {
                //System.out.println("(" + maxRow + " - " + minRow + " / 2) = " + ((maxRow - minRow) / 2));
                maxRow = maxRow - ((maxRow - minRow) / 2);
            } else {
                //System.out.println("(" + maxRow + " - " + minRow + " / 2) = " + ((maxRow - minRow) / 2));
                minRow = ((maxRow - minRow) / 2) + minRow;
            }
        }
        //System.out.println("Returning : " + minRow);
        return minRow;
    }

    private static int findColumn(String columnString) {
        int maxColumn = 8;
        int minColumn = 0;

        for(int i = 0; i < columnString.length(); i++) {
            //System.out.print(columnString.charAt(i) + " || ");
            if(columnString.charAt(i) == 'L') {
                //System.out.println("(" + maxColumn + " - " + minColumn + " / 2) = " + ((maxColumn - minColumn) / 2));
                maxColumn = maxColumn - ((maxColumn - minColumn) / 2);
            } else {
                //System.out.println("(" + maxColumn + " - " + minColumn + " / 2) = " + ((maxColumn - minColumn) / 2));
                minColumn = ((maxColumn - minColumn) / 2) + minColumn;
            }
        }
        //System.out.println("Returning : " + minColumn);
        return minColumn;
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
