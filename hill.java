import java.util.Scanner;

public class hill {
    static int[][] key = new int[2][2];
    static void create(String s){
        for (int i = 0; i < s.length(); i++) {
            key[i/2][i%2]=s.charAt(i)-'a';
        }
    }
    static String encrypt(String s){
        String str="";
        int n=s.length()%2==0?s.length()/2:s.length()/2+1;
        int[][] arr = new int[2][n];
        int i;
        for ( i = 0; i < s.length()/2; i++) {
            int c = s.charAt(2*i)-'a';
            int d = s.charAt(2*i+1)-'a';
            arr[0][i]= c;
            arr[1][i]= d;
        }
        if(2*i<s.length()){
            arr[0][i]=s.charAt(2*i)-'a';
            arr[1][i]='x'-'a';
        }
        int[][] arr2 = new int[2][n];
        arr2 = multiply(key,arr);

        for (int j = 0; j < arr2[0].length; j++) {
            str+=(char)(arr2[0][j]%26+'a');
            str+=(char)(arr2[1][j]%26+'a');
        }
        return str;
    }
    static int[][] multiply(int[][] key, int[][] arr){
        int[][] arr2 = new int[2][arr[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr.length; k++) {
                   arr2[i][j] += key[i][k]*arr[k][j]; 
                }
            }  
        }
        // for (int i = 0; i < key.length; i++) {
        //     for (int j = 0; j < arr2[0].length; j++) {
        //         System.out.print(arr2[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return arr2;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("enter key: ");
        String s = obj.next();
        create(s);
        System.out.print("enter plaintext: ");
        String text = obj.next();
        System.out.println("cipher text: "+encrypt(text));
    }
}
