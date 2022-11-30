import java.util.Scanner;
import java.lang.Math;

abstract class Shape {
    public abstract double Area();
    public abstract double Volume();
}

abstract class Point extends Shape {
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getY(){
        return  y;
    }

}

class Circle extends Shape {
    private double radious;

    public void setRadious(double radious){
        this.radious = radious;
    }

    public double getRadious(){
        return radious;
    }

    public double Area(){
        double area = Math.PI * radious * radious;
        return area;

    }

    public double Volume(){
        return 0;
    }
}

class Cylinder extends Circle {
    private double height;

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double Area(){

        double area = 2 * super.Area() + 2 * Math.PI * super.getRadious() * height;
        return area;

    }

    public double Volume(){

        double volume = 2 * Math.PI * super.getRadious() * height;
        return volume;
    }
}

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();

        System.out.println("Enter radious and height.");

        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();
        double h = input.nextDouble();

        circle.setRadious(r);
        cylinder.setHeight(h);
        cylinder.setRadious(r);
        System.out.println("Area of CIRCLE is: " + circle.Area());
        System.out.println("Area of CYLINDER is: " + cylinder.Area());
        System.out.println("Volume of CYLINDER is: " + cylinder.Volume());

    }
}






