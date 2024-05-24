import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt(); // starting seed
        int b = scanner.nextInt(); // ending seed
        int n = scanner.nextInt(); // number of pseudorandom numbers
        int k = scanner.nextInt(); // Upper bound (exclusive) for pseudorandom numbers

        int minMax = Integer.MAX_VALUE;
        int seedWithMinMax = a;

        for (int seed = a; seed <= b; seed++){
            Random random = new Random(seed);

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++){
                int randomNumber = random.nextInt(k);
                max = Math.max(max, randomNumber);
            }

            if (max < minMax || (max == minMax && seed < seedWithMinMax)){
                minMax = max;
                seedWithMinMax = seed;
            }
        }
        System.out.println(seedWithMinMax);
        System.out.println(minMax);
    }
}