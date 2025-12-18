public class TestOctagon {
    public static void main(String[] args) {

        Octagon oct1 = new Octagon(5);

        System.out.println("Original Octagon");
        System.out.println("Side: " + oct1.getSide());
        System.out.println("Area: " + oct1.getArea());
        System.out.println("Perimeter: " + oct1.getPerimeter());

        Octagon oct2 = oct1.clone();

        System.out.println("\nCloned Octagon");
        System.out.println("Side: " + oct2.getSide());
        System.out.println("Area: " + oct2.getArea());
        System.out.println("Perimeter: " + oct2.getPerimeter());

        int result = oct1.compareTo(oct2);

        System.out.println("\nComparison Result: " + result);
        if (result == 0)
            System.out.println("Both octagons have the same area.");
        else if (result > 0)
            System.out.println("Original is larger.");
        else
            System.out.println("Cloned is larger.");

        System.out.println("\nAre both objects same in memory? " + (oct1 == oct2));
    }
}
