import java.util.ArrayList;

public class PomodoroMachine {
    public static void tWelcomeMsg() {
        StdOut.println("Welcome to traditional Pomodoro!");
        StdOut.println("In the following format, \n"
                               + "25 7 25 7 25 7 25 end \n"
                               + "with your first and last inputs being work timers, "
                               + "enter your Pomodoro Sequence in minutes:");
    }

    public static void pWelcomeMsg() {
        StdOut.println("Welcome to Personal Pomodoro!");
        StdOut.println("This is a pomodoro sequence which you will start "
                               + "and stop based on how long you can work "
                               + "without losing focus.");
    }

    private static void pClosingMsg() {
        StdOut.println("Next time you use TraditionalPomodoro, use this "
                               + "sequence for a sequence that is catered to "
                               + "your study habits!");
    }

    private static boolean equalsY() {
        String userInput = StdIn.readString();
        return userInput.equalsIgnoreCase("y");
    }

    private static boolean equalsG() {
        String userInput = StdIn.readString().toUpperCase();
        return userInput.equals("G");
    }

    private static void notY() {
        throw new IllegalArgumentException("You did not enter Y.");
    }

    public static void main(String[] args) {

        StdOut.println("Would you like to start a personal pomodoro or traditional"
                               + " pomodoro? \n"
                               + "enter 'traditional' or 'personal'");
        String answer = StdIn.readString();

        StdOut.println("What sound would you like to set as your alarm? "
                               + "Enter 'applause', 'bowling', 'siren', 'cow', "
                               + "'duck', 'geese', or 'mario'");

        String soundAnswer = "sounds/" + StdIn.readString() + ".wav";

        if (answer.equalsIgnoreCase("traditional")) {

            ArrayList<Timer> inputSequence = new ArrayList<Timer>();

            tWelcomeMsg();

            String userInput;

            while (true) {
                userInput = StdIn.readString();
                if (userInput.equals("end")) break;
                inputSequence.add(new Timer(Double.parseDouble(userInput)));
            }

            TraditionalPomodoro tp = new TraditionalPomodoro(inputSequence);

            while (true) {
                StdOut.println("Enter Y to start next interval.");
                if (equalsY()) {
                    tp.beginNext();
                    StdAudio.playInBackground(soundAnswer);
                    if (tp.size() == 0) {
                        StdOut.println("Study Session Complete!");
                        break;
                    }
                }
                else notY();
            }
            // traditional pomodoro exclusive
        }
        else if (answer.equalsIgnoreCase("personal")) {
            pWelcomeMsg();

            PersonalPomodoro pp = new PersonalPomodoro();

            while (true) {
                StdOut.println("Enter Y to start a pomodoro.");
                if (equalsY()) {
                    pp.startSelfPomodoro();
                }
                else notY();
                StdOut.println("Enter Y to end a pomodoro.");
                if (equalsY()) {
                    pp.stopSelfPomodoro();
                    StdAudio.playInBackground(soundAnswer);
                }
                else notY();

                StdOut.println("You must now take a break. Enter the duration of "
                                       + "the break you would like to take "
                                       + "in minutes.");
                pp.startbreak(Double.parseDouble(StdIn.readString()));
                StdAudio.playInBackground(soundAnswer);

                StdOut.println("If you would like to stop the study session, "
                                       + "enter G. Otherwise, enter any key.");
                if (equalsG()) break;
            }

            pp.sequence();

            pClosingMsg();
        }
    }
}
