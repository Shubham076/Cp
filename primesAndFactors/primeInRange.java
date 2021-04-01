public class primeInRange {
//print count of prime nos between range a, b
    public static int[] primeSeive(int n){
        int[] arr = new int[n + 1];

        for(int i = 3; i <= n; i += 2){
            arr[i] = 1;
        }
        for(int i = 3; i * i <= n; i += 2){
            if(arr[i] == 1){
                for(long j = i * i; j <= n; j += i){
                    arr[(int)j] = 0;
                }
            }
        }
        arr[0] = arr[1] = 0;
        arr[2] = 1;
        return arr;
    }
    public static void main(String[] args){
        int n = 1000000;
        int[] ps = primeSeive(n);
        int[] cs = new int[n + 1];
        for(int i = 1; i <= n; i++){
            cs[i] = ps[i] + cs[i - 1];
        }

        int q = 1;
        while(q-- > 0){
            int a = 1;
            int b = 10;
            System.out.println(cs[b] - cs[a - 1]);
        }
    }
}
