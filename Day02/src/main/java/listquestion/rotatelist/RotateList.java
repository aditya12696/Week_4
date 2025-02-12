package listquestion.rotatelist;
import java.util.*;

public class RotateList {

    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();

        // Handle empty list to prevent division by zero error
        if (size == 0) return list;

        // Ensure positions are within the valid range
        positions = positions % size;

        List<Integer> rotatedList = new ArrayList<>();

        // Add elements from the rotation index to the end
        for (int i = positions; i < size; i++) {
            rotatedList.add(list.get(i));
        }

        // Add the first part of the list to the end
        for (int i = 0; i < positions; i++) {
            rotatedList.add(list.get(i));
        }

        return rotatedList;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int positions = 2;

        // Print rotated list
        System.out.println(rotateList(list, positions));
    }
}
