import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] students = new String[10];
        int studentCount = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(".")) break;
            if (studentCount < 10) students[studentCount++] = input;
        }
        
        String[] classes = new String[10];
        int classCount = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(".")) break;
            if (classCount < 10) classes[classCount++] = input;
        }
        
        String[] attendance = new String[100];
        int attendanceCount = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(".")) break;
            attendance[attendanceCount++] = input;
        }
        scanner.close();

        String[] sessions = new String[50];
        int sessionCount = 0;
        
        for (int c = 0; c < classCount; c++) {
            String[] parts = classes[c].split(" ");
            int hour = Integer.parseInt(parts[0]);
            String day = parts[1];
            
            int dayNum = day.equals("MO") ? 1 : day.equals("TU") ? 2 :
                        day.equals("WE") ? 3 : day.equals("TH") ? 4 :
                        day.equals("FR") ? 5 : day.equals("SA") ? 6 : 7;
            
            int firstDate = (dayNum >= 2) ? (dayNum - 2 + 1) : (dayNum + 5 + 1);
            
            for (int date = firstDate; date <= 30; date += 7) {
                sessions[sessionCount++] = String.format("%d:%s:%d", hour, day, date);
            }
        }
        
        for (int i = 0; i < sessionCount; i++) {
            String[] parts = sessions[i].split(":");
            System.out.printf("%s:00 %s %2d|", parts[0], parts[1], Integer.parseInt(parts[2]));
        }
        System.out.println();
        
        for (int s = 0; s < studentCount; s++) {
            System.out.print(students[s]);
            int pad = 10 - students[s].length();
            for (int p = 0; p < pad; p++) System.out.print(" ");
            System.out.print("|");
            
            for (int d = 1; d < sessionCount; d++) {
                String[] sessionParts = sessions[d].split(":");
                int hour = Integer.parseInt(sessionParts[0]);
                int date = Integer.parseInt(sessionParts[2]);
                
                boolean found = false;
                for (int a = 0; a < attendanceCount; a++) {
                    String[] attParts = attendance[a].split(" ");
                    if (attParts[0].equals(students[s]) && 
                        Integer.parseInt(attParts[1]) == hour &&
                        Integer.parseInt(attParts[2]) == date) {
                        
                        System.out.print(attParts[3].equals("HERE") ? "         1|" : "        -1|");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.print("          |");
            }
            System.out.println();
        }
    }
    
    private static int getDayOffset(String day) {
        int target = day.equals("MO") ? 1 : day.equals("TU") ? 2 :
                    day.equals("WE") ? 3 : day.equals("TH") ? 4 :
                    day.equals("FR") ? 5 : day.equals("SA") ? 6 : 7;
        
        int diff = target - 2;
        if (diff < 0) diff += 7;
        return diff;
    }
    
    private static int getDayOfWeek(String day) {
        switch (day) {
            case "MO": return 1;
            case "TU": return 2;
            case "WE": return 3;
            case "TH": return 4;
            case "FR": return 5;
            case "SA": return 6;
            case "SU": return 7;
            default: return 0;
        }
    }
    
    private static String getDayName(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1: return "MO";
            case 2: return "TU";
            case 3: return "WE";
            case 4: return "TH";
            case 5: return "FR";
            case 6: return "SA";
            case 7: return "SU";
            default: return "";
        }
    }
    
    private static int getFirstDate(int targetDayOfWeek) {
        int firstDay = 2;
        int diff = targetDayOfWeek - firstDay;
        if (diff < 0) diff += 7;
        return 1 + diff;
    }

    private static int getDayOfWeekForDate(int date) {
        return ((date - 1) % 7 + 2) > 7 ? ((date - 1) % 7 + 2) - 7 : ((date - 1) % 7 + 2);
    }
}