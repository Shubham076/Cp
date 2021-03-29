	import java.util.Scanner;
class binaryExponentiation{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int p = scn.nextInt();
		System.out.println(power(n, p));
	}

//O(Logp)
	public static int power(int a, int b){
		int res = 1;
		while(b > 0){
			if((b & 1) == 1){  //if number is odd
				res *= a;
			}
			a *= a;
			b >>= 1; // reducing the power of b by 2 
		}
		return res;
	}
}