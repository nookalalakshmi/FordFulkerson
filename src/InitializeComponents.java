import java.util.*;

public class InitializeComponents {
	
	/**
	 * Authors: Lakshmi Nookala, Ankit Khandelwal
	 * This class initializes the following
	 * Graph with vertices and edges
	 * Edge information - capacity, flow forward and flow backward
	 * Adds paths as mentioned in getAllPaths functions
	 */
	HashMap<Integer, ArrayList<int[]>> allPaths = new HashMap<Integer, ArrayList<int[]>>();
	ArrayList<int[]> path = new ArrayList<int[]>();
	public int[] initializeVertices(int size)
	{
		int[] temp=new int[size];
		for(int i=0;i<size;i++)
		{
			temp[i]=i;
		}
		return temp;
	}
	
	public HashMap<Integer,int[]> initializeEdge(HashMap<Integer,int[]> edgeList)
	{
		/*edgeList.put(0, new int[]{1,2});
		edgeList.put(1, new int[]{2,3});
		edgeList.put(2, new int[]{4});
		edgeList.put(3, new int[]{4,5});
		edgeList.put(4, new int[]{5});
		edgeList.put(5, new int[]{});*/
		
		/*edgeList.put(0, new int[]{1,2});
		edgeList.put(1, new int[]{3});
		edgeList.put(2, new int[]{3,4});
		edgeList.put(3, new int[]{5});
		edgeList.put(4, new int[]{6});
		edgeList.put(5, new int[]{7});
		edgeList.put(6, new int[]{7});
		edgeList.put(7, new int[]{});*/
		
		return edgeList;
	}

	public HashMap<int[],Integer> initializeEdgeCapacity(HashMap<int[],Integer> edgeCapacity)
	{
		/*edgeCapacity.put(new int[]{0,1}, 3);
		edgeCapacity.put(new int[]{0,2}, 3);
		edgeCapacity.put(new int[]{1,2}, 2);
		edgeCapacity.put(new int[]{1,3}, 3);
		edgeCapacity.put(new int[]{2,4}, 2);
		edgeCapacity.put(new int[]{3,4}, 4);
		edgeCapacity.put(new int[]{3,5}, 3);
		edgeCapacity.put(new int[]{4,5}, 3);*/
		
		/*edgeCapacity.put(new int[]{0,1}, 6);
		edgeCapacity.put(new int[]{0,2}, 6);
		edgeCapacity.put(new int[]{1,3}, 6);
		edgeCapacity.put(new int[]{2,3}, 6);
		edgeCapacity.put(new int[]{2,4}, 6);
		edgeCapacity.put(new int[]{3,5}, 6);
		edgeCapacity.put(new int[]{4,6}, 6);
		edgeCapacity.put(new int[]{5,7}, 6);
		edgeCapacity.put(new int[]{6,7}, 6);*/
		
		return edgeCapacity;
	}
	public HashMap<int[],Integer> initializeEdgeFFlow(HashMap<int[],Integer> edgeFFlow)
	{
		/*edgeFFlow.put(new int[]{0,1}, 0);
		edgeFFlow.put(new int[]{0,2}, 0);
		edgeFFlow.put(new int[]{1,3}, 0);
		edgeFFlow.put(new int[]{1,2}, 0);
		edgeFFlow.put(new int[]{2,4}, 0);
		edgeFFlow.put(new int[]{3,4}, 0);
		edgeFFlow.put(new int[]{3,5}, 0);
		edgeFFlow.put(new int[]{4,5}, 0);*/
		
	/*	edgeFFlow.put(new int[]{0,1}, 0);
		edgeFFlow.put(new int[]{0,2}, 0);
		edgeFFlow.put(new int[]{1,3}, 0);
		edgeFFlow.put(new int[]{2,3}, 0);
		edgeFFlow.put(new int[]{2,4}, 0);
		edgeFFlow.put(new int[]{3,5}, 0);
		edgeFFlow.put(new int[]{4,6}, 0);
		edgeFFlow.put(new int[]{5,7}, 0);
		edgeFFlow.put(new int[]{6,7}, 0);*/
		
		return edgeFFlow;
	}
	public HashMap<int[],Integer> initializeEdgeBFlow(HashMap<int[],Integer> edgeBFlow)
	{
		/*edgeBFlow.put(new int[]{1,0}, 0);
		edgeBFlow.put(new int[]{2,0}, 0);
		edgeBFlow.put(new int[]{2,1}, 0);
		edgeBFlow.put(new int[]{3,1}, 0);
		edgeBFlow.put(new int[]{4,2}, 0);
		edgeBFlow.put(new int[]{4,3}, 0);
		edgeBFlow.put(new int[]{5,3}, 0);
		edgeBFlow.put(new int[]{5,4}, 0);*/
		
		/*edgeBFlow.put(new int[]{1,0}, 0);
		edgeBFlow.put(new int[]{2,0}, 0);
		edgeBFlow.put(new int[]{3,1}, 0);
		edgeBFlow.put(new int[]{3,2}, 0);
		edgeBFlow.put(new int[]{4,2}, 0);
		edgeBFlow.put(new int[]{5,3}, 0);
		edgeBFlow.put(new int[]{6,4}, 0);
		edgeBFlow.put(new int[]{7,5}, 0);
		edgeBFlow.put(new int[]{7,6}, 0);*/

		
		return edgeBFlow;
	}

	public HashMap<Integer, ArrayList<int[]>> getAllPaths(HashMap<Integer, int[]> edgeList, int[] vertices)
	{
		int k = 0;

		ArrayList<int[]> tempPath1 = new ArrayList<int[]>();
		ArrayList<int[]> tempPath2 = new ArrayList<int[]>();
		ArrayList<int[]> tempPath3 = new ArrayList<int[]>();
		ArrayList<int[]> tempPath4 = new ArrayList<int[]>();	
		
		/*tempPath1.add(new int[]{0,1});
		tempPath1.add(new int[]{1,2});
		tempPath1.add(new int[]{2,4});
		tempPath1.add(new int[]{4,5});
		allPaths.put(k, tempPath1);
		
		tempPath3.clear();
		k = k+1;
		tempPath3.add(new int[]{0,1});
		tempPath3.add(new int[]{1,3});
		tempPath3.add(new int[]{3,5});
		allPaths.put(k, tempPath3);
		
		tempPath2.clear();
		k = k+1;
		tempPath2.add(new int[]{0,1});
		tempPath2.add(new int[]{1,3});
		tempPath2.add(new int[]{3,4});
		tempPath2.add(new int[]{4,5});
		allPaths.put(k, tempPath2);
		
		tempPath4.clear();
		k = k+1;
		tempPath4.add(new int[]{0,2});
		tempPath4.add(new int[]{2,4});
		tempPath4.add(new int[]{4,5});
		allPaths.put(k, tempPath4);*/
		
		
		/*//Test case with all 6
		tempPath1.add(new int[]{0,1});
		tempPath1.add(new int[]{1,3});
		tempPath1.add(new int[]{3,5});
		tempPath1.add(new int[]{5,7});
		allPaths.put(k, tempPath1);
		
		tempPath3.clear();
		k = k+1;
		tempPath3.add(new int[]{0,2});
		tempPath3.add(new int[]{2,3});
		tempPath3.add(new int[]{3,5});
		tempPath1.add(new int[]{5,7});
		allPaths.put(k, tempPath3);
		
		tempPath2.clear();
		k = k+1;
		tempPath2.add(new int[]{0,2});
		tempPath2.add(new int[]{2,4});
		tempPath2.add(new int[]{4,6});
		tempPath1.add(new int[]{6,7});
		allPaths.put(k, tempPath2);*/
		
		return allPaths;
	}
		
}
