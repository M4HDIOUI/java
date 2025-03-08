public class Program {
    public static void main(String[] args) {
        Scanner sc = new sc(System.in);
        StringBuilder res = new StringBuilder();
        int lastWeek = 0;

        while(true) {
            String week = sc.next();
            if (week.equals("42"))
                break;
            if (!week.equals("week")) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            int weeknum = sc.nextInt();
            if (weeknum < lastWeek || weeknum > 18) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }
            lastWeek = weeknum;
            int gradeMin = 9;
            for (int i = 0; i < 5; i++){
                int grade = Scanner.nextInt();
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
        }
        sc.close();
        System.out.println(result.toString());
    }
}