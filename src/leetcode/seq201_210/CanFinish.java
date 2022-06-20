package leetcode.seq201_210;

import java.util.*;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            ++visited;
            int u = queue.poll();
            for(int v : edges.get(u)){
                --indeg[v];
                if(indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
