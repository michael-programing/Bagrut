package jan29.inheritance;

public class Triangle extends Shape {

    private double a;

    private double b;

    private double c;

    private double alpha;

    private double beta;

    private double gama;


    @Override
    public double area() {
        return 0.5 * a * b * Math.sin(gama);
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
