/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/
/*
Analysis:
Be careful with the question, for [1,2,2], [2,2] is needed.
Here we use another way different from the previous problem to solve this problem.

First, consider there is no duplicates, how to generate the subsets?
Say n is the # of the elements,
when n=1, subsets :  {}, {"1"},  "i" means the ith element.
when n=2, subsets:   {}, {"1"}, {"2"}, {"1", "2"}
when n=3, subsets:   {}, {"1"}, {"2"}, {"1", "2"}, {"3"}, {"1","3"}, {"2","3"}, {"1", "2","3"}
So, the way of generating subsets is:
From 2 to n, COPY the previous subsets, add the current element, push back to the subsets list.

Then we take the duplicates into account, the same example:
when n=1, subsets :  {}, {"1"},  "i" means the ith element.
when n=2, subsets:   {}, {"1"}, {"2"}, {"1", "2"}
when n=3, but "2"=="3" subsets: 
   {}, {"1"}, {"2"}, {"1", "2"}, {"3"}, {"1","3"}, {"2","3"}, {"1", "2","3"}
since "2"=="3", which truly is:
   {}, {"1"}, {"2"}, {"1", "2"}, {"2"}, {"1","2"}, {"2","2"}, {"1", "2","2"}
where the bold ones are not needed.
So, how these two subsets are generated? They are from the subsets of n=1.

In sum up, when meet the same element as previous one, then generate new subsets ONLY from the subsets generated from previous iteration, other than the whole subsets list.
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null) return result;
        Arrays.sort(num);
        
        //add empty set
		result.add(new ArrayList<Integer>());
        
		// store the subsets generated from previous iteration
        ArrayList<ArrayList<Integer>> previousTemp = null;
        
        for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			
			if(i == 0 || num[i] != num[i-1]) {
			    //get sets that are already in result
    			for (ArrayList<Integer> a : result) {
    				temp.add(new ArrayList<Integer>(a));
    			}
			}
			else {
			    for (ArrayList<Integer> a : previousTemp) {
    				temp.add(new ArrayList<Integer>(a));
    			}
			}
			
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(num[i]);
			}
			
			previousTemp = temp;
	 
			result.addAll(temp);
		}
		
	    return result;
    }
}