/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
/*
这个题目很有规律性，首先从结果的第一个数字考虑。如果第一个数字固定为1，那么一共有(n-1)!种组合。以此类推，有：
 1 <= k <= (n-1)!则第一个数字为第1小的数字即1，下一步k=k
 (n-1)! < k <= 2*(n-1)!则第一个数字为第2小的数字即2，下一步k=k-(n-1)!
 ...
 这样每次这样做循环，取出当前还剩下的数字中第v(v由k和(n-1)!的关系算出，见上表)小的数字，放在相应的位置上。
*/
public class Solution {
    public String getPermutation(int n, int k) {
        String str = "";
		
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			integers.add(i);
		}
		
		for(int i = n; i >= 2; i--) {
			int factorial = factorial(i-1);
			int value = 0;
			if(k >= factorial && k % factorial == 0) 		value = k / factorial - 1;
			else						value = k / factorial;
			k = k - value*factorial;
			str = str + String.valueOf(integers.get(value));
			integers.remove(value);
		}
		
		str = str + String.valueOf(integers.get(0));
		return str;
    }
    
    public int factorial(int n) {
		int f = 1;
		for(int i = 2; i <= n; i++) {
			f = f*i;
		}
		return f;
	}
}