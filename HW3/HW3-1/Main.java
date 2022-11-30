import java.util.ArrayList;
import java.util.Scanner;

class Person {

    private String firstName;
    private String lastName;
    private int age;
    private int nationalID;

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastNmae(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }


    public int getNationalID(){
        return nationalID;
    }

    public void setNationalID(int nationalID){
        this.nationalID = nationalID;
    }


}

class Employee extends Person{

    private int salary;
    private int departmentID;


    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getDepartmentID(){
        return departmentID;
    }
    public void setDepartmentID(int departmentID){
        this.departmentID = departmentID;
    }
}

class DataScientist extends Employee {
    public DataScientist(String fName, String lName, int age, int nID, int salary, int dID){
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setAge(age);
        this.setNationalID(nID);
        this.setSalary(salary);
        this.setDepartmentID(dID);
    }
}

class SoftwareEngineer extends Employee {
    public SoftwareEngineer(String fName, String lName, int age, int nID, int salary, int dID){
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setAge(age);
        this.setNationalID(nID);
        this.setSalary(salary);
        this.setDepartmentID(dID);

    }
}

class ProductManager extends Employee {
    public ProductManager(String fName, String lName, int age, int nID, int salary, int dID) {
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setAge(age);
        this.setNationalID(nID);
        this.setSalary(salary);
        this.setDepartmentID(dID);

    }
}

class Calculate {
    // Define arrayList of objects.
    private ArrayList<DataScientist> DS = new ArrayList<DataScientist>();
    private ArrayList<SoftwareEngineer> SE = new ArrayList<SoftwareEngineer>();
    private ArrayList<ProductManager> PM = new ArrayList<ProductManager>();

    public void compute() {

        Scanner input = new Scanner(System.in);
        System.out.println("if you want to strat the program ENTER \"start\":");
        String order;

        // Get input until enter "start" to start getting employees information.
        while (true) {
            order = input.nextLine();
            if (order.equals("start"))
                break;
        }

        System.out.println("Enter information of employees and  at the end enter \"exit\":");
//        System.out.println("Role |FirstName |LastName |Age |NationalID |Salary |DepartmentID");
        String info = input.nextLine();

        // Get employees information until enter "exit".
        while (!info.equals("exit")) {
            String[] splited = info.split("\\s+");
            String role = splited[0];
            String firstName = splited[1];
            String lastName = splited[2];
            int age = Integer.parseInt(splited[3]);
            int nID = Integer.parseInt(splited[4]);
            int salary = Integer.parseInt(splited[5]);
            int dID = Integer.parseInt(splited[6]);
            if (role.equals("DataScientist")) {
                DataScientist tmp = new DataScientist(firstName, lastName, age, nID, salary, dID);
                DS.add(tmp);
            }
            else if (role.equals("SoftwareEngineer")) {
                SoftwareEngineer tmp = new SoftwareEngineer(firstName, lastName, age, nID, salary, dID);
                SE.add(tmp);
            }
            else if (role.equals("ProductManager")) {
                ProductManager tmp = new ProductManager(firstName, lastName, age, nID, salary, dID);
                PM.add(tmp);
            }
            info = input.nextLine();
        }

        // Calculating mean of dataScientists salaries
        int sumDS = 0;
        for (DataScientist obj: DS){
            sumDS += obj.getSalary();
        }
        int meanDS = sumDS / DS.size();

        // Calculating mean of softwareEngineers salaries
        int sumSE = 0;
        for (SoftwareEngineer obj: SE){
            sumSE += obj.getSalary();
        }
        int meanSE = sumSE / SE.size();

        // Calculating mean of productManagers salaries
        int sumPM = 0;
        for (ProductManager obj: PM){
            sumPM += obj.getSalary();
        }
        int meanPM = sumPM / PM.size();

        // Print result
        System.out.println("Mean of dataScientists salaries : " + meanDS);
        System.out.println("Mean of softwareEngineers salaries: " + meanSE);
        System.out.println("Mean of productManagers salaries: " + meanPM);
    }
}


public class Main {

    public static void main(String[] args) {

        // Create obj and call method to calculate the result.
        Calculate calculate = new Calculate();
        calculate.compute();
    }
}
