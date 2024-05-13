import java.util.Scanner;
class Info {
    public static int count = 0;
    public static void takinfo(String mchoco) {
        String mychoco = "chocolate";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < mchoco.length(); j++) {
                if (mchoco.charAt(j) == mychoco.charAt(i)) {
                    count += 1;
                    ++i;
                    j = 0;
                    if (count == 9) {
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }
        System.out.println("no");
    }
}
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String choco = input.nextLine();
        Info.takinfo(choco);
        input.close();
    }
}
