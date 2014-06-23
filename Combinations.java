/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
/*
Note that in each combination, former number is smaller than the following number.  In another word, [1, 2] and [2, 1] is considered as the same combination, and only [1, 2] is required as the result in this problem.

As usual, if we don't have any idea about the solution, we can try to manually process 1-2 examples.  Here is an example I tried, n=5, k=3: 

1 - 2 - 3
  - 3 - 4
  - 4 - 5
  - 5 - X
2 - 3 - 4
  - 4 - 5
  - 5 - X
3 - 4 - 5
  - 5 - X
4 - 5 - X

we can see that in the first position of the resulting combinations we can chose number 1-5.  Assume that we chose 1 for the 1 position of the combination, then we can choose 2-5 for the second position.  Till we chosen numbers for all position, we can have one possible combination.
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        
        if(n < k) return res;
        helper(n, k, res, comb, 1);
        return res;
    }
    
    public void helper(int n, int k, List<List<Integer>> res, List<Integer> comb, int start) {
        if(comb.size() == k) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        else {
            for(int i=start; i <= n; i++) {
                comb.add(i);
                helper(n, k, res, comb, i+1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}