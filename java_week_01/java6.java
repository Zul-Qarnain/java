import java.util.Scanner;
class Java6{
    public static int sum=0;
    public static int sumarr(int[] myarr){
        for(int myarrs : myarr){
            sum +=myarrs;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+"th element of array: ");
            arr[i] = input.nextInt();
        }
        System.out.println("Sum of array is: "+sumarr(arr));
        input.close();
    }
}