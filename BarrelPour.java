import java.util.Scanner;

public class BarrelPour {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scan.nextInt();
        scan.nextLine();
        while(t>0){
            String nk = scan.nextLine();
            String[] nkn = nk.split(" ");
            int n = Integer.parseInt(nkn[0]);
            int k = Integer.parseInt(nkn[1]);
            String as = scan.nextLine();
            String [] asn = as.split(" ");
            long[] a = new long[n];
            for (int i=0; i<n; i++){
                a[i] = Long.parseLong(asn[i]);
            }
            a = quickSort(a, 0, a.length-1);
            int counter = a.length-2;
            for (int i=k; i>0; i--){
                a = pour(a, counter);
                counter--;
            }
            System.out.println(a[a.length-1]-a[a.length-2]);
            t--;
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

    public static long[] pour(long[] a, int i){
        if (a.length >= 2){
            a[a.length-1] += a[i];
            a[i] = 0;
        }
        return a;
    }

    public static long[] quickSort(long[]a, int first, int last){
        long piv = (a[first] + a[last])/2;
        int i = first;
        int j = last;

        while (i<j){
            while (a[i]<piv) i++;
            while (a[j]>piv) j--;
            if(i<=j){
                long x = a[i];
                a[i] = a[j];
                a[j] = x;
                i++;
                j--;
            }
        }
        if(first<j){
            a = quickSort(a, first, j);
        }
        if(last>i){
            a = quickSort(a, i, last);
        }

        return a;
    }

    public static int[] countingSort(int[] a){
        int[] holdinio = new int[(int)Math.round(Math.pow(10, 9)+1)];
        int max = 0;
        for (int i=0; i<a.length; i++){
            holdinio[a[i]]++;
            if(a[i]>max)max = a[i];
        }
        int counter = 0;
        for (int i=0; i<=max; i++){
            if(holdinio[i]>0){
                for (int e=0; e<holdinio[i]; e++){
                    a[counter] = i;
                    counter++;
                }
            }
        }
        return a;
    }
}
