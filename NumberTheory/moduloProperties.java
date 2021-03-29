class moduloProperties{
	static int x;
	static int y;
	static int GCD;
	public static void main(String[] args){
		int a = 10;
		int b = 5;
		int m = 9;

		modularAddition(a, b, m);
		modularSubstraction(a, b, m);
		modularMultiplication(a, b, m);
		modularDivison(a, b, m);
		// System.out.println(multiplicativeModuloInverse(18, 7));
	}

	public static void modularAddition(int a, int b, int m){
		// (a + b) % m = ((a % m) + (b % m)) % m
		int lhs = (a + b) % m;
		int rhs = ((a % m ) + (b % m)) % m;
		System.out.println(lhs + " " + rhs);
	}

	public static void modularSubstraction(int a, int b, int m){
		// (a - b) % m = ((a % m) - (b % m) + m) % m
		int lhs = (a - b) % m;
		int rhs = ((a % m ) - (b % m) + m) % m;
		System.out.println(lhs + " " + rhs);
	}

	public static void modularMultiplication(int a, int b, int m){
		// (a * b) % m = ((a % m) * (b % m)) % m
		int lhs = (a * b) % m;
		int rhs = ((a % m ) * (b % m)) % m;
		System.out.println(lhs + " " + rhs);
	}

	public static void modularDivison(int a, int b, int m){
	// (a / b) % m = ((a % m) * (b(inverse) % m)) % m
	// b(inverse) = multiplicative modulo inverse of b with respect to m;
		int lhs = (a / b) % m;
		int binv = multiplicativeModuloInverse(b, m);
		int rhs = ((a % m ) * (binv % m)) % m;
		System.out.println(lhs + " " + rhs);
	}

	public static int multiplicativeModuloInverse(int a, int m){
		extendedEuclidean(a, m);
		return ((x % m) +  m) % m;
	}

	public static void extendedEuclidean(int a, int b){
		if(b == 0){
			x = 1;
			y = 0;
			GCD = a;
			return;
		}
		extendedEuclidean(b, a % b);
		int cx = y;
		int cy = x - (a / b) * y;
		x = cx;
		y = cy;
	}
}