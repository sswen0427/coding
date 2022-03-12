package alibaba2021_4star;

import java.util.*;

public class ShortestTreeChain {
    private static int n = 0;
    private static int[] grade = null;
    private static boolean[] isVisited = null;
    private static Map<Integer, Set<Integer>> graph = null;

    private static int bfs(int index){
        Arrays.fill(isVisited, false);
        Deque<Integer> queue = new ArrayDeque<>();
        int level = grade[index];
        int dis = 0;
        queue.offerFirst(index);
        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int idx = queue.pollLast();
                isVisited[idx] = true;
                if(grade[idx] == level && idx != index){
                    return dis;
                }
                for(int neighbor : graph.get(idx)){
                    if(!isVisited[neighbor]){
                        queue.offerFirst(neighbor);
                    }
                }
            }
            dis += 1;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grade = new int[n+1];
        isVisited = new boolean[n+1];
        graph = new HashMap<>();

        for(int i = 1; i <= n; i++){
            grade[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(!graph.containsKey(u)){
                graph.put(u, new HashSet<>());
            }
            if(!graph.containsKey(v)){
                graph.put(v, new HashSet<>());
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int dis = bfs(i);
            if(dis < min) min = dis;
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
