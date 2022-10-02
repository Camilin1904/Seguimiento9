import java.util.*;

class HorseRace {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scan.nextInt();
        scan.nextLine();
        for (int i=0; i<t; i++){
            int n = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();
            String[] sns = s.split(" ");
            int[] sn = new int[n];
            for (int e=0; e<n; e++)sn[e] = Integer.parseInt(sns[e]);
            sn = sort(sn);
            int hold = Integer.MAX_VALUE;
            for (int e=0; e<n-1; e++){
                if(sn[e+1]-sn[e]<hold) hold = sn[e+1]-sn[e];
            }
            System.out.println(hold);
        }
            
    }

    public static int[] sort(int[] a){
        for(int i=0; i<a.length; i++){
            for(int e=1; e<a.length; e++){
                if(a[e]<a[e-1]){
                    int save = a[e];
                    a[e] = a[e-1];
                    a[e-1] = save;
                }
            }
        }
        return a;
    }
}
