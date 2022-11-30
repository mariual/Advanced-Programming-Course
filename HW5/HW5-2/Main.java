import java.awt.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.String;
import javax.swing.*;

public class Main  {
    public static void main(String[] args) {
        int[][] values = new int[6][6];

        try {
            File obj = new File("filename.txt");
            Scanner myReader = new Scanner(obj);
            // Skip line one.
            myReader.nextLine();

            // Read each line and split.
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(" ");
                int i = Integer.parseInt(temp[0]);
                int j = Integer.parseInt(temp[1]);
                int value = Integer.parseInt(temp[2]);
                values[i][j] = value;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Display Sparse matrix in console.
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++)
                System.out.printf("%10d" , values[i][j]);
            System.out.println();
        }

        //Display Sparse matrix in GUI.
        JFrame frame = new JFrame("Sparse Matrix ");
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6,6));
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                JLabel l = new JLabel();
                l.setText(Integer.toString(values[i][j]));
                frame.add(l);
            }
        }

    }
}