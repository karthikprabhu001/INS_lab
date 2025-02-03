import java.util.Arrays;
import java.util.HashSet;

public class Playfair{
    static char[][] arr = new char[5][5];

    static void create(String s) {
        int x = 0, y = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            arr[x][y++] = s.charAt(i);
            set.add(s.charAt(i));
            if (y == 5) {
                y = 0;
                x++;
            }
        }
        for (int j = 0; j < 26; j++) {
            char c = (char) ('a' + j);
            if (c == 'j') {
                continue;
            }
            if (!set.contains(c)) {
                arr[x][y++] = c;
                if (y == 5) {
                    y = 0;
                    x++;
                }
            }
        }
    }

    static int[] search(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == c) {
                    int[] a = { i, j };
                    return a;
                }
            }
        }
        int[] b = { -1, -1 };
        return b;
    }

    static String enc(char x, char y) {
        String str = "";
        int[] a = search(x);
        int[] b = search(y);
        if (a[0] == b[0]) {
            int p = (a[1] + 1) % 5;
            int q = (b[1] + 1) % 5;
            str += arr[a[0]][p];
            str += arr[a[0]][q];
            return str;
        } else if (a[1] == b[1]) {
            int p = (a[0] + 1) % 5;
            int q = (b[0] + 1) % 5;
            str += arr[p][a[1]];
            str += arr[q][a[1]];
            return str;
        } else {
            str += arr[a[0]][b[1]];
            str += arr[b[0]][a[1]];
            return str;
        }
    }

    static String encrypt(String p) {
        String d = "";
        int i;
        for (i = 0; i < p.length() - 1; i = i + 2) {
            d += enc(p.charAt(i), p.charAt(i + 1));
        }
        if (i < p.length()) {
            d += enc(p.charAt(i), 'x');
        }
        return d;
    }

    public static void main(String[] args) {
        create("monarchy");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        // int[] a = search('a');
        // System.out.println(Arrays.toString(a));
        String text = "instruments";
        // System.out.println(enc('i', 'n'));
        System.out.println(encrypt(text));
    }
}
