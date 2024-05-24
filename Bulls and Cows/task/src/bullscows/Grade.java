package bullscows;

public class Grade {
    private final int bulls;
    private final int cows;

    public Grade(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public boolean isSolved(int length) {
        return bulls == length;
    }

    @Override
    public String toString() {
        if (bulls == 0 && cows == 0) {
            return "None";
        } else {
            return String.format("%d bull(s) and %d cow(s)", bulls, cows);
        }
    }
}