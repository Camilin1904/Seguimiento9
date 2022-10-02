import java.util.Scanner;

class FrogSort {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scan.nextInt();
        int[] ans = new int[t];
        scan.nextLine();
        for(int a=0; a<t; a++){
            int n = scan.nextInt();
            scan.nextLine();
            String fs = scan.nextLine();
            String fLs = scan.nextLine();
            String[] fsa = fs.split(" ");
            String[] fLsa = fLs.split(" ");
            int[][] f = new int[n][3];
            for (int i=0; i<n; i++){
                f[i][0] = Integer.parseInt(fsa[i]);
                f[i][1] = Integer.parseInt(fLsa[i]);
                f[i][2] = i+1;
            }
            f = sort(f);
            int hits = 0;
            for (int i=0; i<n; i++){
                for (int e=0; e<n; e++){
                    while(f[e][0]>f[i][0]&&f[e][2]<=f[i][2]){
                        f[e][2] +=f[e][1];
                        hits++;
                    }
                    while(f[e][0]<f[i][0]&&f[e][2]>f[i][2]){
                        f[i][2] +=f[i][1];
                        hits++;
                    }
                }  
            } 
            
            ans[a] =hits;
        }
        for (int i=0; i<t; i++){
            System.out.println(ans[i]);
        }
    }
    public static int[][] sort(int[][] a){
        for(int i=0; i<a.length; i++){
            for(int e=1; e<a.length; e++){
                if(a[e][0]<a[e-1][0]){
                    int[] save = a[e];
                    a[e] = a[e-1];
                    a[e-1] = save;
                }
            }
        }
        return a;
    }
}
