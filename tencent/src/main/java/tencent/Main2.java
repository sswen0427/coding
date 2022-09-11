package tencent;
import java.util.*;

public class Main2 {
    private boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2) return true;
        if(n == 3) return true;
        int sqrtN = (int)Math.sqrt(n);
        for(int i = 2; i <= sqrtN; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private Set<Integer> getAllPrime(int n){
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            if(isPrime(i)){
               set.add(i);
            }
        }
        return set;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组 
     * @return int整型
     */
    public int getNumber (int[] a) {
        Set<Integer> allPrimes = getAllPrime(200000);
        LinkedList<Integer> list = new LinkedList<>();
        for(int num : a){
            list.add(num);
        }
        while (list.size() != 1){
            int size = list.size();
            for(int i = 1; i <= size; i++){
                int num = list.pollFirst();
                if(allPrimes.contains(i)){
                    list.addLast(num);
                }
            }
        }
        return list.pollFirst();
        // write code here
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int[] nums = {1, 2, 3, 4};
        System.out.println(main2.getNumber(nums));
    }
}