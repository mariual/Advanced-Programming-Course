import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.lang.String;

class Sort {
    private Set<String> words = new TreeSet<String>();
    private Set<String> numbers = new TreeSet<String>();

    // Check type of element.
    static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;

        return true;
    }

    // Add elements to data structures.
    public void check(String data) {
        if (isNumber(data))
            numbers.add(data);
        else
            words.add(data);
    }

    // Print sorted numbers and words.
    public void display() {
        for (Object object : numbers) {
            String element = (String) object;
            System.out.print(element + " ");
        }
        System.out.println();

        for (Object object : words) {
            String element = (String) object;
            System.out.print(element + " ");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Sort obj = new Sort();

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                obj.check(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        obj.display();
    }
}