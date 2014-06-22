/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
/*
首先将数组排序，去掉重复的元素。之后用枚举法。首先排出第一个元素，之后新的元素插入所有可能的位置，得到新的排列，对所有元素做这个过程。
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
		// sort array and discard repeated elements in array
        Arrays.sort(num);
        int i = 1, j = 1;
        int N = num.length;
        while(j < N) {
            if(num[j] == num[j-1]) j++;
            else num[i++] = num[j++];
        }
        
		// add first element
        ArrayList<Integer> firstElem = new ArrayList<Integer>();
        firstElem.add(num[0]);
        res.add(firstElem);
        
		// add second element to last one by one
        for(int k = 1; k < i; k++) {
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> elem : res) {
                for(int l = 0; l <= elem.size(); l++) {
                    ArrayList<Integer> combine = new ArrayList<Integer>(elem);
                    combine.add(l, num[k]);
                    newRes.add(combine);
                }
                res = newRes;
            }
        }
        return res;
    }
}