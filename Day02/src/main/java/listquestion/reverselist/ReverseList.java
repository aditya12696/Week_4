package listquestion.reverselist;
import java.util.*;

public class ReverseList {

    // Method to reverse an ArrayList
    public static List<Integer> reverseArrayList(List<Integer> list) {
        List<Integer> reversedList = new ArrayList<>();

        // Iterate from the last index to the first and add elements to the new list
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    // Method to reverse a LinkedList
    public static List<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();

        // Iterate from the last index to the first and add elements to the new list
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Print reversed lists
        System.out.println("Reversed ArrayList: " + reverseArrayList(arrayList));
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkedList));
    }
}
