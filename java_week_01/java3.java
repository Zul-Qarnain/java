//use of tinary oparator
import java.util.Scanner;
class java3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your resutl: ");
        float grade = input.nextFloat();
        String result = (grade>=3.75) ? "Safe" : "Hoga mara sara";
        System.out.println(result);
        input.close();
    }
}