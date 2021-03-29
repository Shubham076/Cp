import java.math.*;
public class BigIntegerDemo{

	public static void Factorial(int N){
		BigInteger ans = new BigInteger("1");
		for(int i = 2; i <= N; i++){
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		System.out.println("Factorial: " + ans);
	}

	public static void gcd(int a, int b){
		BigInteger n1 = BigInteger.valueOf(a);
		BigInteger n2 = BigInteger.valueOf(b);
		System.out.println("GCD: " + n1.gcd(n2));
	}

	public static void negate(long n){
		BigInteger a = BigInteger.valueOf(n).negate();
		System.out.println("Negative Value:" + a);
	}
	public static void main(String[] args){
		int N = 10;
		long n = 457833939;
		Factorial(N);
		gcd(8, 12);
		negate(n);

		// other useful methods
		int a = 10;
		int  b  = 20;
		BigInteger a1 = BigInteger.valueOf(a);
		BigInteger b1 = BigInteger.valueOf(b);

		BigInteger p = new BigInteger("9874");
		BigInteger q = new BigInteger("5874");
		BigInteger r = new BigInteger("-5945");
		System.out.println("Add: " + p.add(q));
		System.out.println("Subtract: " + p.subtract(q));
		System.out.println("Divide: " + p.divide(q));
		System.out.println("Mod: " + p.mod(q));
		System.out.println("Power: " + p.pow(3));
		System.out.println("Max: " + p.max(q));
		System.out.println("Min: " + p.min(q));
		System.out.println("Next Prime: " + p.nextProbablePrime());
		System.out.println("Are equal?: " + p.equals(q));
		System.out.println("Abs value of r: " + r.abs());

		// conversions from biginteger to data types
		System.out.println("Int value of r: " + r.intValue());
		System.out.println("Long value of r: " + r.longValue());
		System.out.println("Float value of r: " + r.floatValue());
		System.out.println("Double value of r: " + r.doubleValue());
	}
}