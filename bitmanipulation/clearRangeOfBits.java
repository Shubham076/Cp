class clearRangeOfBits{
	public static void clearLastIBits(int n, int i){
		int mask = (-1 << i);
		System.out.println("No is: " + Integer.toBinaryString(n)+ "(" + n + ")");
		int ans = (n & mask);
		System.out.println("After clearing last three bits number is: " + Integer.toBinaryString(ans) + "(" + ans + ")");
	}

	public static void clearRangeIToJ(int n, int i, int j){
		// j is left position and i is right position
		int ones = -1;
		int a = (ones << (j + 1));
		int b = (1 << i) - 1;  // 2 ^ (n - 1) - 1
		int mask = a | b;
		int ans = n & mask;
		System.out.println(n + ": " + Integer.toBinaryString(n));
		System.out.println(ans + ": " + Integer.toBinaryString((ans)));

	}
	public static void main(String[] args){
		clearLastIBits(15, 3);
		clearRangeIToJ(31, 2, 3);
	}
}