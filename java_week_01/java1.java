import java.util.Scanner;
class java1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String myname = input.nextLine();
        System.out.print("Enter your age: ");
        int myage = input.nextInt();
        System.out.println("My name is: "+myname);
        System.out.println("MY age is: "+myage);
        input.close();
    }
}