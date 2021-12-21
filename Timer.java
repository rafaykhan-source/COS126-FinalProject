public class Timer {

    private double studyLength;
    private double minutes;

    public Timer(double x) {
        studyLength = x * 60;
        minutes = x;
    }

    public boolean isTimeUp() {
        Stopwatch clock = new Stopwatch();
        while (true) {
            if (clock.elapsedTime() == studyLength) {
                return true;
            }
        }
    }

    public String timeLength() {
        return "" + minutes;
    }

    public String toString() {
        return "Timer of " + minutes + " minutes";
    }
}
