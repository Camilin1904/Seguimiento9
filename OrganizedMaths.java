import java.util.Scanner;

public class OrganizedMaths{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String s = scan.next();
        s = s.replace("+", "");
        char[] arr = s.toCharArray();

        arr = sort(arr);
        s="";
        for(int i=0; i<arr.length;i++){
            if(i!=arr.length-1){
                s += arr[i] + "+";
            }
            else{
                s += arr[i];
            }
        }
        System.out.println(s);

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