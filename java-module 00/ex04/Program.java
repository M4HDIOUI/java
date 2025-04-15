import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        boolean endsWith42 = false;
        if (input.length() >= 2) {
            char last = input.charAt(input.length() - 1);
            char secondLast = input.charAt(input.length() - 2);
            endsWith42 = (secondLast == '4' && last == '2');
        }
        
        if (endsWith42) {
            char[] temp = new char[input.length() - 2];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = input.charAt(i);
            }
            input = new String(temp);
        }

        int[] frequency = new int[65536];
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ' && c != '\n') {
                frequency[c]++;
            }
        }

        Character[] sortedChars = new Character[65536];
        int count = 0;
        for (int c = 0; c < 65536; c++) {
            if (frequency[c] > 0) {
                sortedChars[count++] = (char)c;
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                boolean shouldSwap = false;
                if (frequency[sortedChars[i]] < frequency[sortedChars[j]]) {
                    shouldSwap = true;
                }
                else if (frequency[sortedChars[i]] == frequency[sortedChars[j]] 
                        && sortedChars[i] > sortedChars[j]) {
                    shouldSwap = true;
                }
                
                if (shouldSwap) {
                    Character temp = sortedChars[i];
                    sortedChars[i] = sortedChars[j];
                    sortedChars[j] = temp;
                }
            }
        }

        int top = count < 10 ? count : 10;
        int maxFreq = count > 0 ? frequency[sortedChars[0]] : 0;

        for (int i = 0; i < top; i++) {
            System.out.print(frequency[sortedChars[i]] + "  ");
        }
        System.out.println();

        for (int row = 10; row > 0; row--) {
            for (int i = 0; i < top; i++) {
                if (frequency[sortedChars[i]] * 10 / maxFreq >= row) {
                    System.out.print("#  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < top; i++) {
            System.out.print(sortedChars[i] + "  ");
        }
        System.out.println();
    }
}