import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()){
            System.out.println("IllegalArgument");
            System.exit(-1);
        }

        int num = sc.nextInt();
        sc.close();
        if (num <= 1){
            System.out.println("IllegalArgument");
            System.exit(-1);
        }
        boolean isP = true;
        int step = 0;
        for (int i = 2; i * i <= num; i++){
            step++;
            if (num % i == 0) {
                isP = false;
                break;
            }
        }
        System.out.println(isP + " " + step);
    }
}
