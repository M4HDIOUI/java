import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        int lastWeek = 0;

        while(true) {
            String weekInput = sc.nextLine().trim();
            if (weekInput.equals("42"))
                break;

            if (!weekInput.startsWith("Week ")) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            int weeknum = Integer.parseInt(weekInput.substring(5).trim());

            if (weeknum < lastWeek || weeknum > 18) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            lastWeek = weeknum;

            int gradeMin = 9;
            String[] grades = sc.nextLine().split("\\s+");
            if (grades.length != 5) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }

            for (String gradeStr : grades) {
                int grade = Integer.parseInt(gradeStr);
                if (grade < 1 || grade > 9) {
                    System.out.println("IllegalArgument");
                    System.exit(-1);
                }
                if (grade < gradeMin)
                    gradeMin = grade;
            }

            res.append("Week ").append(weeknum).append(" ");
            for (int i = 0; i < gradeMin; i++) {
                res.append("=");
            }
            res.append(">");
            res.append("\n");
        }

        sc.close();
        System.out.println(res.toString());
    }
}
