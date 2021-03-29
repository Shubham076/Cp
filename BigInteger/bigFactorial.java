import java.util.*;
class bigFactorial{
	public static void main(String[] args){
		int n = 100;
		factorial(n);
	}

	public static void factorial(int n){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		for(int i = 2; i <= n; i++){
			multiply(list, i);
		}
		Collections.reverse(list);
		System.out.println(list);
	}
	public static void multiply(ArrayList<Integer> l, int k){
		int carry = 0;
		int s = l.size();
		for(int i = 0; i < s; i++){
			int n = (l.get(i) * k) + carry;
			carry = n / 10;
			l.set(i , n % 10);
		}

		while(carry > 0){
			l.add(carry % 10);
			carry /= 10;
		}
	}
}