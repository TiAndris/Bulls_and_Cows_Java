import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double dotProduct = x1 * x2 + y1*y2;

        double magnitude1 = Math.sqrt(x1*x1+y1*y1);
        double magnitude2 = Math.sqrt(x2*x2 + y2*y2);

        double cosine = dotProduct / (magnitude1*magnitude2);

        double angleInRadians = Math.acos(cosine);

        double angleINDegrees = Math.toDegrees(angleInRadians);

        System.out.println(angleINDegrees);
    }
}