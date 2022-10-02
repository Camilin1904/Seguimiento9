import java.util.*;

public class thing {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int tests = reader.nextInt();

        for (int i = 0; i < tests; i++) {

            int n = reader.nextInt();
            Integer[] weightsList = new Integer[n];
            Integer[] jumpsList = new Integer[n];

            reader.nextLine();
            String[] weights = reader.nextLine().split(" ");
            String[] jumps = reader.nextLine().split(" ");


            for (int j = 0; j < n; j++) {
                weightsList[j] = (Integer.parseInt(weights[j]));
                jumpsList[j] = (Integer.parseInt(jumps[j]));
            }

            int ans1 = solve(n,weightsList,jumpsList);
            System.out.println(ans1);

        }
    }

        public static int solve(int n, Integer[] weightList, Integer[] jumpsList)
        {
            int ans1 = 0;
            int prev = -1;
            int[] tempW = new int[n];
            boolean[] verify = new boolean[n];

            for(int i=0; i<n; i++) {
                // lleno mi temp weight de todos los weight
                tempW[i] = weightList[i];
            }

            // ordeno mi temp weight
            Arrays.sort(tempW);

            for(int i=0; i<n; i++) {
                // Si el menor weight del temp es igual al valor en posición i de weight, el verify en esa posición
                // cambia a true y el prev a la posición

                // Si o si lo va a encontrar en el weight list, solo que necesito su posición para colocarlo como prev y
                // verificarlo
                if(tempW[0]==weightList[i])
                {
                    verify[i] = true;
                    prev = i;
                    break;
                }
            }

            for(int i=1; i<n; i++) {
                int k = 0;

                while(k<n) {
                    // k es la posición del primer verificado que está ordenado


                    // Si esa posición no ha sido verificada y justo esa posición de weight list está donde debe estar
                    // es decir, está ordenada, entonces la verifico y rompo el while para seguir (esto se repite tantas veces
                    // hayan frogs) hasta n
                    if(!verify[k] && weightList[k]==tempW[i]) {
                        verify[k] = true;
                        break;
                    }
                    k+=1;
                }

                // Si k es menor o igual al prev (prev es la posición donde se encuentra el weight menor en la lista de weights
                // desordenados)
                if(k<=prev) {
                    int jumps = k;
                    while (jumps <= prev) {
                        jumps += jumpsList[k];
                        ans1 += 1;
                    }
                    prev = jumps;


                } else {
                    prev = k;
                }
            }

            return ans1;
        }
    }

