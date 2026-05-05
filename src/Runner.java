import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("How many disks do you want to test? ");
        int numDisks = kb.nextInt();

        // quick sanity check so it doesn't explode output
        if (numDisks <= 0) {
            System.out.println("Enter a number greater than 0.");
        } else {
            System.out.println("\nSteps to solve:\n");
            Towers.moveDisks(numDisks, 'A', 'C', 'B');
        }

        kb.close();
    }
}