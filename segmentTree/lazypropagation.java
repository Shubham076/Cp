import java.util.*;

//note in case of sum
// the lazy values are resolved by tree[i] + inc * [e - s + 1]
class lazypropagation{
	static int[] lazy = new int[1000];
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

	public static void lazyRangeUpdate(int[] tree, int s, int e, int qs, int qe, int inc, int i){
		if(lazy[i] != 0){
			tree[i] += lazy[i];
			//case of non leaf node
			if(s != e){
				lazy[2 * i] += lazy[i];
				lazy[2 * i + 1] += lazy[i];
			}
			lazy[i] = 0;
		}
			//no overlap
		//     *qs----*qe                     *qs----*qe
 		//                 *s-------------*e
 		if(s > qe || e < qs){
 			return;
 		}

 		//complete overlap
 		if(s >= qs && e <= qe){
 			tree[i] += inc;
 			if(s != e){
 				lazy[2 * i] += inc; 
 				lazy[2 * i + 1] += inc; 
 			}
 			return;
 		}
 		int mid = (s + e) / 2;
 		lazyRangeUpdate(tree, s, mid, qs, qe, inc, 2 * i);
 		lazyRangeUpdate(tree, mid + 1, e, qs, qe, inc, 2 * i + 1);
 		tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
	}

	public static int lazyquery(int[] tree, int s, int e, int qs, int qe, int i){
		if(lazy[i] != 0){
			tree[i] += lazy[i];
			//case of non leaf node
			if(s != e){
				lazy[2 * i] += lazy[i];
				lazy[2 * i + 1] += lazy[i];
			}
			lazy[i] = 0;
		}
		if (s >= qs && e <= qe) {
			return tree[i];
		}
		if (s > qe || e < qs) {
			return Integer.MAX_VALUE;
		} 
		int mid = (s + e) / 2;
		int left = lazyquery(tree, s, mid, qs, qe, 2 * i);
		int right = lazyquery(tree, mid + 1, e, qs, qe, 2 * i + 1);
		return Math.min(left, right);
	}

	public static void main(String[] args){
		int[] arr = {1, 3, 2, -5, 6, 4};
		int n = arr.length	;
		int[] tree = new int[4 * arr.length + 1];
		buildTree(arr, tree, 0, arr.length - 1, 1);

		lazyRangeUpdate(tree, 0, n - 1, 0, 2, 10, 1);
		lazyRangeUpdate(tree, 0, n - 1, 0, 4, 10, 1);
		System.out.println(lazyquery(tree, 0 , n - 1, 1, 1, 1));
		
		lazyRangeUpdate(tree, 0, n - 1, 3, 4, 10, 1);
		System.out.println(lazyquery(tree, 0 , n - 1, 3, 5, 1));

	}
}