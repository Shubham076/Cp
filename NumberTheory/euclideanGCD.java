class euclideanGCD{
	public static void main(String[] args){
		int n = 18;
		int m = 7;
		System.out.println(gcd(n, m));
	}
// O(logN)
	public static int gcd(int a, int b){
		return b == 0 ? a : gcd(b, a % b);
	}
}