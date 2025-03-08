public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coffReqCount = 0;

        while (true) {
            int num = sc.nextInt();
            if (num == 42)
                break;
            
            if (isPrime(sumOfDig(num)))
                coffReqCount++;
        }
        sc.close();
        System.out.println("Count of coffee-request : " + coffReqCount);
    }
    private static int sumOfDig(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static boolean isPrime(int num) {
        if (num < 2){
            false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}