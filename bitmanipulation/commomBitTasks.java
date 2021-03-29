class commomBitTasks{
	public static void main(String[] args){
		//checking number is odd or even;
		int n = 5;
		isOdd(n);
		System.out.println(getBit(n , 1));
		setBit(5, 1);
		clearBit(5, 2);
		updateBit(5, 1, 1);
	}

	public static void isOdd(int n){
		if((n & 1) == 1){
			System.out.println("Odd");
		}
		else{
			System.out.println("Even");
		}
	}

	public static int getBit(int n , int i){
		int m = (1 << i);
		return (n & m) > 0 ? 1 : 0;
	}

	public static void setBit(int n , int i){
		int m = (1 << i);
		int ans = (n | m);
		System.out.println(ans);
	}

	public static int clearBit(int n , int i){
		int m = ~(1 << i);
		int ans = n & m;
		System.out.println(ans);
		return ans;
	}

	public static void updateBit(int n, int i, int v){
		int x = clearBit(n, i);
		int mask = (v << i);
		int ans = n | mask;
		System.out.println(ans);
	}
}