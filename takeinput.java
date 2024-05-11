import java.util.Scanner;
public class takeinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter your username: ");
        String username = scanner.next();
        System.out.println("Age: " + age);
        System.out.println("Username: " + username);
        scanner.close();
    }
}
