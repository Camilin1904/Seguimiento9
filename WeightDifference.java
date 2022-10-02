
    import java.util.Scanner;

    class WeightDifference {
        public static Scanner scan = new Scanner(System.in);
        public static void main(String[] args) {
            int t = scan.nextInt();
            int[] returns = new int[t];
            scan.nextLine();
            for(int i=0; i<t; i++){
                String in = scan.nextLine();
                String[] nk = in.split(" ");
                int k = Integer.parseInt(nk[1]);
                int n = Integer.parseInt(nk[0]);
                String wIn = scan.nextLine();
                String[] w = wIn.split(" ");
                int skn = 0, sk = 0;
                int[] wn = new int[n];
                for (int e=0; e<n; e++) wn[e] = Integer.parseInt(w[e]);
                wn = sort(wn);
                if(k<=n-k){
                    for (int e=0; e<n; e++) {
                        if(e<k) sk += wn[e];
                        else skn += wn[e];
                    }
                }else{
                    for (int e=0; e<n; e++) {
                        if(e<n-k)sk += wn[e];
                        else skn += wn[e];
                    }
                }

                returns[i] = skn-sk;
            }
            for (int i=0; i<t; i++)System.out.println(returns[i]);
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
