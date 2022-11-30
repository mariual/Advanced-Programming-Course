import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get number of comments & Define array of string for comments.
        System.out.println("Please enter the number of comments: ");
        Scanner c = new Scanner(System.in);
        int nc = c.nextInt();
        String comments[] = new String[nc];

        Scanner input = new Scanner(System.in);
        int maxLen = 0;     // Maximum length of comments.

        // Get comments.
        System.out.println("Enter IMDB comments: ");
        for (int i = 0; i < comments.length; i++) {
            comments[i] = input.nextLine();
            int len = comments[i].length();
            if (len > maxLen)
                maxLen = len;
        }

        // Define Table of character.
        char tableOfChars[][] = new char[nc][maxLen];

        // Delete numbers, signs,... & Convert all character to lower case &  Creat table of character.
        for (int i = 0; i < comments.length; i++) {
            for (int j = 0; j < comments[i].length(); j++) {
                if (Character.isLetter(comments[i].charAt(j)) == true) {
                    for (int k = 0; k < tableOfChars[i].length; k++) {
                        if (tableOfChars[i][k] == '\u0000') {
                            tableOfChars[i][k] = Character.toLowerCase(comments[i].charAt(j));
                            break;
                        }
                    }
                }
            }
        }

//        // Print table of character.
//        for (int i = 0; i < tableOfChars.length; i++) {
//            for (int j = 0; j < tableOfChars[i].length; j++) {
//                System.out.print(tableOfChars[i][j]);
//            }
//            System.out.print("\n");
//        }

        // Get number of words & Define array of string for words.
        System.out.println("Please enter number of words: ");
        Scanner w = new Scanner(System.in);
        int nw = w.nextInt();
        String words[] = new String[nw];

        // Get words.
        for (int i = 0; i < words.length; i++)
            words[i] = input.nextLine().toLowerCase();

        // Define two array to store number of found words in rows and columns.
        int[] rowsCount = new int[nw];
        int[] columnsCount = new int[nw];
        Arrays.fill(rowsCount, 0);
        Arrays.fill(columnsCount, 0);

        // Search in rows.
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < tableOfChars.length; j++) {
                for (int k = 0; k < tableOfChars[j].length; k++) {
                    int iw = 0;     // Index of word
                    int ic = k;     // Index of comment
                    while (iw != words[i].length() && ic < tableOfChars[j].length) {
                        if (words[i].charAt(iw) == tableOfChars[j][ic]) {
                            iw++;
                            ic++;
                        } else
                            break;
                    }
                    if (iw == words[i].length())
                        rowsCount[i] += 1;
                }
            }
        }

        // Search in columns.
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < maxLen; j++) {
                for (int k = 0; k < tableOfChars.length; k++) {
                    int iw = 0;     // Index of word
                    int ic = k;     // Index of comment
                    while (iw != words[i].length() && ic < tableOfChars.length) {
                        if (words[i].charAt(iw) == tableOfChars[ic][j]) {
                            iw++;
                            ic++;
                        } else
                            break;
                    }
                    if (iw == words[i].length())
                        columnsCount[i] += 1;
                }
            }
        }

        // Print result.
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s -> rows: %d & columns: %d", words[i], rowsCount[i], columnsCount[i]);
            System.out.print('\n');
        }
    }
}