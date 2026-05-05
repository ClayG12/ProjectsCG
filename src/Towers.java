public class Towers {

    // recursive method to solve the Towers of Hanoi problem
    public static void moveDisks(int disks, char start, char target, char helper) {

        // base case: only one disk left, just move it
        if (disks == 1) {
            System.out.println("Move disk 1 from " + start + " -> " + target);
            return;
        }

        // move top (disks - 1) to helper rod first
        moveDisks(disks - 1, start, helper, target);

        // move the largest disk to target
        System.out.println("Move disk " + disks + " from " + start + " -> " + target);

        // move the stack from helper to target
        moveDisks(disks - 1, helper, target, start);
    }
}