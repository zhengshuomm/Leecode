//Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
//
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
public class Nested_List_Weight_Sum_II_364 {
	//  Instead of multiplying by depth, add integers multiple times (by going level by level and adding the unweighted sum to the weighted sum after each level).
	public int depthSumInverse(List<NestedInteger> nestedList) {
	    int unweighted = 0, weighted = 0;
	    while (!nestedList.isEmpty()) {
	        List<NestedInteger> nextLevel = new ArrayList<>();
	        for (NestedInteger ni : nestedList) {
	            if (ni.isInteger())
	                unweighted += ni.getInteger();
	            else
	                nextLevel.addAll(ni.getList());
	        }
	        weighted += unweighted;
	        nestedList = nextLevel;
	    }
	    return weighted;
	}
}
