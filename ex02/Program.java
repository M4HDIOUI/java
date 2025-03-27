import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coffReqCount = 0;

        while (true) {
            int num = sc.nextInt();
            if (num == 42)
                break;

            int sum = 0;
            int temp = num;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            boolean isPrime = true;
            if (sum < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i * i <= sum; i++) {
                    if (sum % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime)
                coffReqCount++;
        }

        sc.close();
        System.out.println("Count of coffee-request : " + coffReqCount);
    }
}
