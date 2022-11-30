import java.util.Scanner;

class Network {

    private char[][] network = new char[5][6];
    private int enter;
    private int exit;

    // Set entrance row.
    public void setEnter() {
        System.out.println("Please enter the entrance row: ");
        Scanner scanner = new Scanner(System.in);
        this.enter = scanner.nextInt();
    }

    // Set exit row.
    public void setExit() {
        System.out.println("Please enter the exit row: ");
        Scanner scanner = new Scanner(System.in);
        this.exit = scanner.nextInt();
    }

    // Modify Network 2d array and set mirrors.
    public void setMirror() {
        System.out.println("Please enter number of mirrors: ");
        Scanner input = new Scanner(System.in);
        int mirrorsCount = input.nextInt();
        input.nextLine();

        for (int i = 0; i < mirrorsCount; i++) {
            System.out.println("Enter info of " + (i + 1) + "th mirror: e.g. 4 3 \\");
            String tmp = input.nextLine();
            String[] spilited = tmp.split(" ");
            int row = Integer.parseInt(spilited[0]) - 1;
            int column = Integer.parseInt(spilited[1]) - 1;
            char mirror = spilited[2].charAt(0);
            network[row][column] = mirror;
        }
    }

    // Display initiated network.
    public void displayNetwork() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(network[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // Check network safety.
    public boolean isOpen() {
        int en = enter - 1;
        int ex = exit - 1;
        int dir = 1;    // Direction : 1=right | 2=Left | 3=up | 4=down
        int i = en;     // Index of row.
        int j = 0;      // Index of column.
        while (true) {
            if (i < 5 & j < 6 & i >= 0 & j >= 0) {
                switch (dir) {
                    case 1: {
                        if (network[i][j] == '/') {
                            dir = 3;
                            i--;
                        } else if (network[i][j] == '\\') {
                            dir = 4;
                            i++;
                        } else if (network[i][j] == '\u0000') {
                            j++;
                        }
                        break;
                    }

                    case 2: {
                        if (network[i][j] == '/') {
                            dir = 4;
                            i++;
                        } else if (network[i][j] == '\\') {
                            dir = 3;
                            i--;
                        } else if (network[i][j] == '\u0000') {
                            j--;
                        }
                        break;
                    }

                    case 3: {
                        if (network[i][j] == '/') {
                            dir = 1;
                            j++;
                        } else if (network[i][j] == '\\') {
                            dir = 2;
                            j--;
                        } else if (network[i][j] == '\u0000') {
                            i--;
                        }
                        break;

                    }

                    case 4: {
                        if (network[i][j] == '/') {
                            dir = 2;
                            j--;
                        } else if (network[i][j] == '\\') {
                            dir = 1;
                            j++;
                        } else if (network[i][j] == '\u0000') {
                            i++;
                        }
                        break;
                    }
                }
            } else {
                if (dir == 1 & i == ex)
                    return true;
                else
                    return false;
            }
        }
    }

    // Find missing mirror.
    public void findMirror() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (network[i][j] == '\u0000') {
                    network[i][j] = '/';
                    if (isOpen()) {
                        System.out.println("Network is SAFE! missing mirror is / and located in row " + (i + 1) + " ,column " + (j + 1));
                        return;
                    } else {
                        network[i][j] = '\\';
                        if (isOpen()) {
                            System.out.println("Network is SAFE! missing mirror is \\ and located in row " + (i + 1) + " ,column " + (j + 1));
                            return;
                        }
                    }
                    network[i][j] = '\u0000';
                }
            }
        }
        System.out.println("Mirror not found and Network is not SAFE!");
    }
}


public class Main {
    public static void main(String[] args) {
        Network obj = new Network();
        obj.setEnter();
        obj.setExit();
        obj.setMirror();
//        obj.displayNetwork();
        if (obj.isOpen()) {
            System.out.println("Network is open and not SAFE!");
        } else {
            obj.findMirror();
        }
    }
}