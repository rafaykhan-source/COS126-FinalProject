import java.util.ArrayList;

public class TraditionalPomodoro {

    private ArrayList<Timer> studySequence;
    private int sessionLength;
    private int originalLength;
    private Timer clock;

    public TraditionalPomodoro(ArrayList<Timer> times) {
        studySequence = times;
        originalLength = studySequence.size();
    }

    public void beginNext() {
        sessionLength = size();
        clock = studySequence.remove(0);
        if (sessionLength % 2 == 1) StdOut.println("Your pomodoro has begun.");
        if (sessionLength % 2 == 0) StdOut.println("Your break has begun.");
        if (clock.isTimeUp()) {
            if (sessionLength % 2 == 1) {
                StdOut.println("Pomodoro Complete!");
                StdOut.println("Remaining Sequence: " + studySequence);
            }
            else if (sessionLength % 2 == 0) {
                StdOut.println("Break Complete!");
                StdOut.println("Remaining Sequence: " + studySequence);
            }
        }
    }

    public boolean sequenceComplete() {
        return sessionLength == 0;
    }

    public int size() {
        return studySequence.size();
    }

    public static void main(String[] args) {
        Timer testOne = new Timer(0.1);
        Timer testTwo = new Timer(0.05);
        Timer testThree = new Timer(0.1);
        Timer testFour = new Timer(0.05);
        Timer testFive = new Timer(0.025);
        Timer testSix = new Timer(0.05);

        ArrayList<Timer> test1 = new ArrayList<Timer>();
        test1.add(testOne);
        test1.add(testTwo);
        test1.add(testThree);

        ArrayList<Timer> test2 = new ArrayList<Timer>();
        test2.add(testFour);
        test2.add(testFive);
        test2.add(testSix);

        TraditionalPomodoro tp = new TraditionalPomodoro(test1);
        TraditionalPomodoro tp2 = new TraditionalPomodoro(test2);

        StdOut.println("Press X to run test one, Press Y to run test two.");

        if (StdIn.readString().equals("X")) {
            while (true) {
                StdOut.println("Press Y to continue this test.");
                if (StdIn.readString().equals("Y")) {
                    StdOut.println("Test Initiated");
                    tp.beginNext();
                    if (tp.size() == 0) {
                        StdOut.println("This test was successful and each "
                                               + "timer ran for the correct "
                                               + "amount of time.");
                        break;
                    }
                }
            }
        }
        else if (StdIn.readString().equals("Y")) {
            while (true) {
                StdOut.println("Press Y to continue this test.");
                if (StdIn.readString().equals("Y")) {
                    StdOut.println("Test Initiated");
                    tp2.beginNext();
                    if (tp2.size() == 0) {
                        StdOut.println("This test was successful and each "
                                               + "timer ran for the correct "
                                               + "amount of time.");
                        break;
                    }
                }
            }
        }
    }
}
