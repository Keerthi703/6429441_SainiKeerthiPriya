import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID and Name (type -1 to stop):");
        while (true) {
            int id = scanner.nextInt();
            if (id == -1) break;
            scanner.nextLine(); // consume newline
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter ID to retrieve name: ");
        int searchId = scanner.nextInt();
        System.out.println("Student Name: " + studentMap.get(searchId));
    }
}
