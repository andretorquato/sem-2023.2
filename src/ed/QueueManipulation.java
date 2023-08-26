import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter total number of people in the queue: ");
        int totalStartIntoQueue = scanner.nextInt();
        
        List<Integer> listOfPeopleStartIntoQueue = new ArrayList<>();
        // System.out.println("Enter the unique IDs of people in the queue:");
        for (int i = 0; i < totalStartIntoQueue; i++) {
            listOfPeopleStartIntoQueue.add(scanner.nextInt());
        }

        // System.out.print("Enter total number of people to be removed: ");
        int totalOutFromQueue = scanner.nextInt();
        
        List<Integer> listPeopleOutFromQueue = new ArrayList<>();
        // System.out.println("Enter the unique IDs of people to be removed:");
        for (int i = 0; i < totalOutFromQueue; i++) {
            listPeopleOutFromQueue.add(scanner.nextInt());
        }

        // Remove the people from the list
        listOfPeopleStartIntoQueue.removeAll(listPeopleOutFromQueue);

        // Print the remaining people in the queue
        // System.out.println("Remaining people in the queue:");
        for (Integer id : listOfPeopleStartIntoQueue) {
            System.out.print(id + " ");
        }
				System.out.print("\n");
        scanner.close();
    }
}
