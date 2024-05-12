import java.util.Scanner;
class Java{
    public static int max_size = 100;
    public static void inputmatrix(int[][] matrix,int r1, int c1){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the element of matrix");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                matrix[i][j] = input.nextInt();
            }
        }
    }
    public static void multimatrix(int[][] matrix1, int[][] matrix2, int[][] res, int r1, int c1, int r2, int c2) {
        if (c1 != r2) {
            System.out.println("Multiplication is impossible!");
            return;
        }
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
    public static void showmatrix(int[][] res,int r1,int c2){
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] arr1 = new int[max_size][max_size];
        int[][] arr2 = new int[max_size][max_size];
        int[][ ] result = new int[max_size][max_size];
        System.out.print("Enter the row1 and col1: ");
        int row1 = input.nextInt();
        int col1 = input.nextInt();
        System.out.print("Enter the row2 and col2: ");
        int row2 = input.nextInt();
        int col2 = input.nextInt();
        System.out.println("Enter the value for matrix1: ");
        inputmatrix(arr1,row1,col1);
        System.out.println("Enter the value for matrix2: ");
        inputmatrix(arr2,row2,col2);
        multimatrix(arr1,arr2,result,row1,col1,row2,col2);
        System.out.println("Showing the matrixmultipication result: ");
        showmatrix(result,row1,col2);
        input.close();
    }
}