class Circle {
    double radius;

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }
}

public class Object {
    public static void main(String[] args) {
        // Create a new Circle object
        Circle myCircle = new Circle();

        // Set the radius of the Circle object
        myCircle.radius = 5.0;

        // Call the area() and circumference() methods on the Circle object
        System.out.println("The area of the circle is: " + myCircle.area());
        System.out.println("The circumference of the circle is: " + myCircle.circumference());

        // Change the radius of the Circle object
        myCircle.radius = 10.0;

        // Call the area() and circumference() methods again on the same Circle object
        System.out.println("The area of the circle is now: " + myCircle.area());
        System.out.println("The circumference of the circle is now: " + myCircle.circumference());
    }
}