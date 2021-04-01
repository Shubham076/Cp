//arr stores count of all the unique prime factors for each number from 1 to n;
public class primeFactors {
    public static void main(String[] args){
        int n = 21;
        countFactors(n);
    }
    public static void countFactors(int n){
        int[] arr = new int[n + 1];
        for(int i = 2; i <= n; i++){
            if(arr[i] == 0){
                for(int j = i; j <= n; j += i){
                    arr[j]++;
                }
            }
        }

        int count = 0;
        for(int i = 2; i <= n; i++){
            if(arr[i] == 2){
                // System.out.println(i + "-" + arr[i]);
                count++;
            }
        }
        System.out.println(count);
    }
}
