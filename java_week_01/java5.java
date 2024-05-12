import java.util.Scanner;
class java5 {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int size = input.nextInt();
    int[] arr = new int[size];
    for(int i=0;i<size;i++){
        System.out.print("Enter the "+i+1+"th Elemenet: ");
        arr[i]=input.nextInt();
    }
    for(int i=0;i<size;i++){
        System.out.println("The "+i+1+"th Elemenet of array is : "+arr[i]); 
    }
    input.close();
    }
}
