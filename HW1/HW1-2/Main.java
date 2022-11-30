import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int arz;
        int tool;
        int noe_shekl;
        String help;

        System.out.println("arz ra vared konid ya agar nemidanid help ra vared konid: ");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            help = input.next();
            System.out.println("Diamond = 0\nTriangel = 1\ncroos = 2 ");
        }
        arz = input.nextInt();

        System.out.println("tool ra vared konid: ");
        tool = input.nextInt();
        System.out.println("noe shekl ra vared konid: ");
        noe_shekl = input.nextInt();

        if (noe_shekl == 0) {
            for (int j = 1; j <= arz; j++) {
                for (int i = 0; i < arz - j; i++) {
                    System.out.print(" ");
                }
                for (int i = 0; i < j; i++) {
                    System.out.print(" *");
                }
                System.out.println("");
            }
            for (int j = arz - 1; j >= 1; j--) {
                for (int i = 0; i < arz - j; i++) {
                    System.out.print(" ");
                }
                for (int i = 0; i < j; i++) {
                    System.out.print(" *");
                }
                System.out.println("");
            }
        }

        if (noe_shekl == 1){
            for (int j = 1; j <= arz; j++) {
                for (int i = 0; i < arz - j; i++) {
                    System.out.print(" ");
                }
                for (int i = 0; i < j; i++) {
                    System.out.print(" *");
                }
                System.out.println("");
            }
        }

        if (noe_shekl == 2){
            for (int i = 0; i < arz; i++) {
                for (int j = 0; j < arz; j++) {
                    if (j == i || j == arz - i - 1) {
                        System.out.print("*");
                    } else System.out.print(" ");

                }


                System.out.println();
            }


        }


    }
}




