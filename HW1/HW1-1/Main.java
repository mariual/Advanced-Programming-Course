import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double pen_price;
        double paper_price;
        double inflation;
        double current_year_expense;
        double next_year_expense;
        double increased_expence;

        System.out.println("Please enter price of a pen: ");
        Scanner input = new Scanner(System.in);
        pen_price = input.nextDouble();

        System.out.println("Please enter price of paper: ");
        paper_price = input.nextDouble();

        System.out.println("Please enter inflation: ");
        inflation = input.nextDouble();
        inflation /= 100;


        current_year_expense = 200 * pen_price + 50 * paper_price;
        next_year_expense = ((pen_price * inflation + pen_price) * 200) + ((paper_price * inflation + paper_price) * 50);
        increased_expence = next_year_expense - current_year_expense;
        System.out.println(" Defrences of expense is: " + increased_expence);






    }
}
