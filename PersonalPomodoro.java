import java.util.ArrayList;

public class PersonalPomodoro {
    private ArrayList<Timer> studySequence;
    private Stopwatch clock;

    public PersonalPomodoro() {
        studySequence = new ArrayList<Timer>();
    }

    public void startSelfPomodoro() {
        clock = new Stopwatch();
        StdOut.println("Pomodoro Initiated.");
    }

    public void stopSelfPomodoro() {
        studySequence.add(new Timer(clock.elapsedTime() / 60.0));
        StdOut.println("Pomodoro Complete!");
        // StdAudio.playInBackground("applause.wav");
    }

    public void startbreak(double minutes) {
        Timer rest = new Timer(minutes);
        StdOut.println("Break Initiated.");
        if (rest.isTimeUp()) {
            studySequence.add(rest);
            StdOut.println("Break Complete!");
            // StdAudio.playInBackground("applause.wav");
        }
    }

    public void sequence() {
        StdOut.println(studySequence.toString());
    }

    public static void main(String[] args) {
        PersonalPomodoro pp = new PersonalPomodoro();

        while (true) {
            StdOut.println("Enter Y to start a pomodoro.");
            if (StdIn.readString().equals("Y")) {
                pp.startSelfPomodoro();
            }

            StdOut.println("Enter Y to end a pomodoro.");
            if (StdIn.readString().equals("Y")) {
                pp.stopSelfPomodoro();
            }

            StdOut.println("This test ran for " + pp.clock.elapsedTime() / 60 + "minutes");

            pp.startbreak(0.1);

            StdOut.println("The break lasted approximately 0.1 minutes");

            StdOut.println("Press G to exit this test.");
            if (StdIn.readString().equals("G")) break;
        }
        pp.sequence();
    }
}
