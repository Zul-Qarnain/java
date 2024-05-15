import java.util.Scanner;
class Java_cls_1 {
    boolean status;
    public void lamp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the status of light: ");
        status = input.nextBoolean();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Java_cls_1 mylight = new Java_cls_1();
        System.out.print("Enter if you want to check your light status: ");
        String check = input.nextLine();
        if (check.equals("yes")) { // Use .equals() for string comparison
            mylight.lamp(); // Call the lamp method to set the status
            if (mylight.status) {
                System.out.println("Your light status is on");
            } else {
                System.out.println("Your light status is off");
            }
        } else {
            System.out.println("You don't want to check your light status");
        }
    }
}
