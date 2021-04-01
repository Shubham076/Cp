import java.util.*;
//space optimized version of prime sieve
public class bitsetSieve {
    public static void main(String[] args){
        int n = 1000000;
        BitSet arr = new BitSet(n);

        for(int i = 3; i <= n; i += 2){
            arr.set(i);
        }
        for(int i = 3; i * i <= n; i += 2){
            if(arr.get(i)){
                for(long j = i * i; j <= n; j += i){
                    arr.clear((int)j);
                }
            }
        }
        arr.clear(0);
        arr.clear(1);
        arr.set(2);
        // System.out.println(arr);

        int N = 10;
        firstNPrimes(N, arr);
    }

    public static void firstNPrimes(int N, BitSet arr){
        int idx = 1;
        int j = 0;
        //first N primes
        while(idx <= N){
            if(arr.get(j)){
                System.out.print(j + " ");
                idx++;
            }
            j++;
        }
    }
}
