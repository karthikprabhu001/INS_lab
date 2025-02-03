import java.util.Scanner;

public class MonoAlphabetic{
    static String encrypt(String s, char[] arr2) {
        String text = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int) c == 32) {
                text += " ";
                continue;
            }
            text += arr2[c - 'a'];
        }
        return text;
    }

    static String decrypt(String s, char[] arr2) {
        String text = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int) c == 32) {
                text += " ";
                continue;
            }
            text += arr2[c - 'a'];
        }
        return text;
    }

    public static void main(String[] args) {
        char[] arr2 = new char[26];
        for (int i = 0; i < 26; i++) {
            arr2[i] = (char) ('z' - i);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("enter String: ");
        String s = sc.nextLine();
        String ans = encrypt(s, arr2);
        System.out.println(ans);
        System.out.println(decrypt(ans, arr2));
    }
}
