package alibaba2021_4star;
import java.util.*;

public class KnowledgeContest {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(Math.abs(o1[0] - o1[1]), Math.abs(o2[0] - o2[1]));
            }
        });
        int maxX = arr[0][0];
        int maxY = arr[0][1];
        int maxMin = 0;
        for(int i = 1; i < n; i++){
            int current;
            if(arr[i][0] > arr[i][1]){
                current=arr[i][1] + maxY;
            }else{
                current=arr[i][0] + maxX;
            }
            if(current > maxMin){
                maxMin = current;
            }
            maxX= Math.max(arr[i][0], maxX);
            maxY= Math.max(arr[i][1], maxY);
        }
        System.out.println(maxMin/2.0);
    }
}
