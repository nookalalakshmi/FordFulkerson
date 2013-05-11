import java.util.*;


public class FordFulkersonMain {
	
	/**
	 * Authors: Lakshmi Nookala, Ankit Khandelwal
	 * This class is the main class for FOrd Fulkerson 
	 * It initializes all data structures by making
	 * apprpopriate functions calls
	 * And also calls the logic class function calculateMaxFlow
	 * to calculate max flow
	 */	
	
	static int size =8;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		InitializeComponents ic = new InitializeComponents();
		int[] vertices = ic.initializeVertices(size);
	
		HashMap<Integer,int[]> edgeList= new HashMap<Integer,int[]>();
		HashMap<int[], Integer> edgeCapacity = new HashMap<int[], Integer>();
		HashMap<int[], Integer> edgeFFlow = new HashMap<int[], Integer>();
		HashMap<int[], Integer> edgeBFlow = new HashMap<int[], Integer>();
		HashMap<Integer, ArrayList<int[]>> allPaths = new HashMap<Integer, ArrayList<int[]>>();
		
		FordFulkersonLogic ff;
		
		edgeList=ic.initializeEdge(edgeList);
		edgeCapacity=ic.initializeEdgeCapacity(edgeCapacity);
		edgeFFlow=ic.initializeEdgeFFlow(edgeFFlow);
		edgeBFlow=ic.initializeEdgeBFlow(edgeBFlow);
		
		allPaths = ic.getAllPaths(edgeList, vertices);
		ff = new FordFulkersonLogic(allPaths, edgeList, edgeCapacity, edgeFFlow, edgeBFlow, vertices);

		long start = System.nanoTime();
		ff.calculateMaximumFlow();
		long end = System.nanoTime();

		System.out.println("Running time : "+(end-start));
		
	}
}