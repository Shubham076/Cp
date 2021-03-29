class uniqueNumbers{
	public static void main(String[] args){
		//All the numbers are repeating twice except one. Find the unique number.
		//properties of xor a^b^a = b;
		// 0 ^ a = a;
		int[] arr = {3,2,3,5,2,5,6};
		int ans = 0;
		for(int i : arr){
			ans ^= i;
		}
		System.out.println(ans);
	}
}