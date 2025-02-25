import java.util.Scanner;

public class vigenere{
    static char[][] arr = new char[26][26];

    static void create() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = (char) ((i + j) % 26 + 'a');
            }
        }
    }

    static String encrypt(String text, String key) {
        String cipher = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            cipher += arr[c - 'a'][key.charAt(i % key.length())-'a'];
        }
        return cipher;
    }

    public static void main(String[] args) {
        create();
        // for (int i = 0; i < 26; i++) {
        // for (int j = 0; j < 26; j++) {
        // System.out.print(arr[i][j]+" ");
        // }
        // System.out.println();
        // }
        Scanner sc = new Scanner(System.in);
        System.out.print("enter key: ");
        String key = sc.next();
        System.out.print("enter plaintext: ");
        String text = sc.next();
        System.out.println(encrypt(text, key));
    }
}
