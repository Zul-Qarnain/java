//change value outside main methode
import java.util.Scanner;
class Shihab{
    public static int num(int x, int y){
        y = y+x;
        System.out.println("The value of y inside the num: "+y);
        return y;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        int x = input.nextInt();
        System.out.print("Enter the value of y: ");
        int y = input.nextInt();
        System.out.println("The value of z inside main: "+y);
        num(x,y);
        System.out.println("The value of z now after num fuction: "+y);
        input.close();
    }
}