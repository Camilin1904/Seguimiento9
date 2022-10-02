import java.util.Scanner;
import java.util.ArrayList;

public class SpykeTalks{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        scan.nextLine();
        String calls = scan.nextLine();
        
        String[] calls2 = calls.split(" ");
        ArrayList<Integer> c = new ArrayList<>();
        for (int i=0; i<calls2.length; i++){
            c.add(Integer.parseInt(calls2[i]));
        }
        if(c.size() ==n){
            c = sort(c);
            int sessions = 0, o = 0, holder = 0;
            for(int i : c){
                
                while(o<n&&i == c.get(o)){
                    o++;
                    if(i!=0) holder++;
                }
                if(holder>2){
                    sessions = -1;
                    break;
                }
                else sessions+=holder/2;
                holder = 0;
            }
            System.out.println(sessions);
        }
       

        
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> a){
        for(int i=0; i<a.size(); i++){
            for(int e=1; e<a.size(); e++){
                if(a.get(e)<a.get(e-1)){
                    int save = a.get(e);
                    a.set(e,a.get(e-1));
                    a.set(e-1, save);
                }
            }
        }
        return a;
    }
}