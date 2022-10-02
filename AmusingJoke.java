import java.util.Scanner;

public class AmusingJoke {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String a = scan.next();
        String b = scan.next();
        String alt = scan.next();
        String ab = a+b;
        if(new String(sort(ab.toCharArray())).equals(new String(sort(alt.toCharArray())))) System.out.println("YES");
        else System.out.println("NO");

    }
    public static char[] sort(char[] a){
        for(int i=0; i<a.length; i++){
            for(int e=1; e<a.length; e++){
                if(a[e]<a[e-1]){
                    char save = a[e];
                    a[e] = a[e-1];
                    a[e-1] = save;
                }
            }
        }
        return a;
    }
}
