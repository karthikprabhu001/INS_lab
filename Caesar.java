import java.util.Scanner;

public class Caesar{
    public static String encrypt(String s, int k){
        String st ="";
        for (int i=0; i<s.length(); i++) {
            if((int)s.charAt(i)==32){
                st+=" ";
                continue;
            }
            int c = (s.charAt(i)-'a'+k)%26;
            st+=(char)(c+97);
        }
        return st;
    }
    public static String decrypt(String st, int k){
        String str="";
        for (int i=0; i<st.length(); i++) {
            if((int)st.charAt(i)==32){
                str+=" ";
                continue;
            }
            int c = (st.charAt(i)-'a'-k)%26;
            if(c<0){
                str+=(char)(c+97+26);
                continue;
            }
            str+=(char)(c+97);
        }
        return str;
    }
    public static void main(String arg[]){
        Scanner obj = new Scanner(System.in);
        System.out.print("enter string: ");
        String s = obj.nextLine();
        System.out.print("enter key: ");
        int k = obj.nextInt();

        String st = encrypt(s,k);
        System.out.println(st);       
        System.out.println(decrypt(st,k));
    }
}