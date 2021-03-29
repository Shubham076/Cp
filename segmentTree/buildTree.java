import java.util.*;
//tree finding the min queries
class buildTree {

	//time complexity O(N)
	public static void buildTree(int[] arr, int[] tree, int s, int e, int i) {
		if (s == e) {
			tree[i] = arr[s];
			return;
		}
		int mid = (s + e) / 2;
		buildTree(arr, tree, s, mid, 2 * i);
		buildTree(arr, tree, mid + 1, e , 2 * i + 1);

		tree[i] = Math.min(tree[2 * i] , tree[2 * i + 1]);
		return;
	}
	//time complexity O(LogN)
	public static int query(int[] tree, int s, int e, int qs, int qe, int i) {
		// case 1 complete overlap
		if (s >= qs && e <= qe) {
			return tree[i];
		}
		//no overlap
		// *qs-------*qe                       *qs-------*qe
		//                 *s-------------*e
		 if (s > qe || e < qs) {
			return Integer.MAX_VALUE;
		} 
			int mid = (s + e) / 2;
			int left = query(tree, s, mid, qs, qe, 2 * i);
			int right = query(tree, mid + 1, e, qs, qe, 2 * i + 1);
			return Math.min(left, right);
		
	}

	//time complexity O(LogN)
	public static void update(int[] tree, int s, int e, int i, int increment, int idx) {
		//no overlap
		//            *n                       *n
		//                 *s-------------*e
		if (s > i || e < i) {
			return;
		}
		//leaf node
		if(s == e){
			System.out.println("Working");
			tree[idx] += increment;
			return;
		}
		int mid = (s + e) / 2;
		update(tree, s, mid, i, increment, 2 * idx);
		update(tree, mid + 1, e, i, increment, 2 * idx + 1);
		tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
	}

//update in range O(N)
	public static void update(int[] tree, int s, int e, int qs, int qe, int increment, int idx) {
		//no overlap
		//     *qs----*qe                     *qs----*qe
 		//                 *s-------------*e
		if (s > qe || e < qs) {
			return;
		}
		//leaf node
		if(s == e){
			tree[idx] += increment;
			return;
		}
		int mid = (s + e) / 2;
		update(tree, s, mid, qs, qe, increment, 2 * idx);
		update(tree, mid + 1, e, qs, qe, increment, 2 * idx + 1);
		tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		int[] arr = {1, 3, 2, -5, 6, 4};
		int[] tree = new int[4 * arr.length + 1];
		buildTree(arr, tree, 0, arr.length - 1, 1);

		update(tree, 0 , arr.length - 1, 3, 5, 10, 1);
		// for(int i = 1; i <= 13; i++){
		// 	System.out.print(tree[i] + " ");
		// }
		System.out.println();

		while (q-- > 0) {
			int l = scn.nextInt();
			int r = scn.nextInt();
			int ans = query(tree, 0, arr.length - 1, l, r, 1);
			System.out.println(ans);
		}
	}
}
