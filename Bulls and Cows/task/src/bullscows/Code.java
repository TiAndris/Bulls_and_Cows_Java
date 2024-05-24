package bullscows;

public class Code {
    private final String value;
    private final int length;
    private final int symbols;

    public Code(String value, int length, int symbols) {
        this.value = value;
        this.length = length;
        this.symbols = symbols;
    }

    public Grade check(Code other) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < length; i++) {
            if (value.charAt(i) == other.value.charAt(i)) {
                bulls++;
            } else if (value.contains(String.valueOf(other.value.charAt(i)))) {
                cows++;
            }
        }
        return new Grade(bulls, cows);
    }
}