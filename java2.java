//take input from user and check either the number is even or odd ?
import java.util.Scanner;
class java2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int num = input.nextInt();
        if(num%2==0){
            System.out.println("The number you have enter "+num+" is even number");
        }else{
            System.out.println("The numnber you have enter "+num+" is odd number");
        }
        input.close();
    }
}