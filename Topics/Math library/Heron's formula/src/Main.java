import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double p = (a+b+c)/2.0;
        double sqrt = p*(p-a)*(p-b)*(p-c);


        double ergebnis = Math.sqrt(sqrt);
        System.out.println(ergebnis);

    }
}