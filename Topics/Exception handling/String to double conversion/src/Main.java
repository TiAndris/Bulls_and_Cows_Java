import java.util.Scanner;

class Converter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(convertStringToDouble(input));
    }


    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e){
            return 0;
        }
    }
}