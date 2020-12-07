import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class part2 {
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
        String[] passportFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        boolean qualified = true;
        String field;
        int factor;
        
        for(int i = 0; i < passportFields.length; i++) {
            if (qualified) {
                qualified = false;
                for(int x = 0; x < splitBuffer.length; x++) {
                    
                    if ((splitBuffer[x].substring(0, 3)).equals(passportFields[i])) {
                        
                        field = (splitBuffer[x]).split(":")[1];
                        switch(i) {
                            case 0:
                            
                                //byr (Birth Year) - four digits; at least 1920 and at most 2002.
                                factor = Integer.parseInt(field);
                                qualified = (factor >= 1920 && factor <= 2002);
                            break;
                            case 1:
                            
                                //iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                                factor = Integer.parseInt(field);
                                qualified = (factor >= 2010 && factor <= 2020);
                            break;
                            case 2:
                                //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                                factor = Integer.parseInt(field);
                                qualified = (factor >= 2020 && factor <= 2030);
                            break;

                            case 3:
                                /*hgt (Height) - a number followed by either cm or in:
                                    If cm, the number must be at least 150 and at most 193.
                                    If in, the number must be at least 59 and at most 76.
                                */
                                if (field.contains("cm")) {
                                    factor = Integer.parseInt(field.split("cm")[0]);
                                    qualified = (factor >= 150 && factor <= 193);
                                } else if (field.contains("in")) {
                                    factor = Integer.parseInt(field.split("in")[0]);
                                    qualified = (factor >= 59 && factor <= 76);
                                } else {
                                    qualified = false;
                                }
                            break;

                            case 4:
                                //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                                if (field.charAt(0) == '#' && field.length() == 7) {
                                    boolean test = true;
                                    field = field.substring(1, field.length());
                                    for(int y = 0; y < field.length(); y++) {
                                        if (test && !((field.charAt(y) > 47 && field.charAt(y) < 58) || (field.charAt(y) > 96 && field.charAt(y) < 103)))
                                            test = false;
                                    }
                                    qualified = test;
                                }
                            break;
                            case 5:
                                //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                                String[] eyeColor = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                                for(int y = 0; y < eyeColor.length; y++) {
                                    if (eyeColor[y].equals(field)) {
                                        qualified = true;
                                        break;
                                    }
                                }
                            break;
                            case 6:
                                //pid (Passport ID) - a nine-digit number, including leading zeroes.
                                boolean test = true;
                                if (field.length() == 9) {
                                    for(int y = 0; y < field.length(); y++) {
                                        if(!(field.charAt(y) > 47 && field.charAt(y) < 58))
                                            test = false;
                                    }
                                } else {
                                    test = false;
                                }
                                qualified = test;
                            break;
                        }
                    }   
                }
            } else {
                break;
            }
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
