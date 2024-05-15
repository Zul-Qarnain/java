import java.util.Scanner;
class java4{public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number [] = {0,1,2,3,4,5,6,7,8,9};
        System.out.print("Enter the number of elements you want see form the array: ");
        int chek = input.nextInt();
        for(int i=0;i<chek;i++){
            System.out.println("Array of index "+i+": "+number[i]);
        }
        /*for(int number: numbers){
            int i =0;
            System.out.println("Array of index "+(++i)+": "+number);
        } */ 
        input.close();
    }
}
