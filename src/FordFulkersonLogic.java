import java.util.*;
import java.util.Map.Entry;


public class FordFulkersonLogic {
	
	/**
	 * Authors: Lakshmi Nookala, Ankit Khandelwal
	 * This class calculates Maxflow
	 */
	
	HashMap<Integer, ArrayList<int[]>> allPaths;
	HashMap<Integer, ArrayList<int[]>> newPaths = new HashMap<Integer, ArrayList<int[]>>();
	HashMap<Integer, int[]> edgeList;
	HashMap<int[], Integer> edgeCapacity;
	HashMap<int[], Integer> edgeFFlow;
	HashMap<int[], Integer> edgeBFlow;
	ArrayList<int[]> saturationEdges = new ArrayList<int[]>();
	int[] vertices;
	int[] tempEdgeVertices, copyEdge;
	int maxFlow=0;
	
	FordFulkersonLogic(HashMap<Integer, ArrayList<int[]>> allPaths1, HashMap<Integer, int[]> edgeList1, HashMap<int[], Integer> edgeCapacity1, HashMap<int[], Integer> edgeFFlow1, HashMap<int[], Integer> edgeBFlow1, int[] vertices1)
	{
		allPaths = allPaths1;
		edgeList = edgeList1;
		edgeFFlow = edgeFFlow1;
		edgeBFlow = edgeBFlow1;
		edgeCapacity = edgeCapacity1;
		vertices = vertices1;
	}
	
	public void calculateMaximumFlow() {
		
		int tempCapacity1, minFlowEdge = (int) Double.POSITIVE_INFINITY;
		Iterator<Entry<int[], Integer>> edgeIterator;
		ArrayList<int[]> curPath = new ArrayList<int[]>();
		Iterator<Integer> pathKeyIterator = allPaths.keySet().iterator();
		Entry<int[], Integer> temp = null;
		//int l=0;
		while(pathKeyIterator.hasNext())
		{
			minFlowEdge=(int) Double.POSITIVE_INFINITY;
			curPath = allPaths.get(pathKeyIterator.next());
			int k=0;
			for(int i=0;i<curPath.size();i++)
			{
				edgeIterator = edgeCapacity.entrySet().iterator();
				while(edgeIterator.hasNext())
				{
					temp = edgeIterator.next();
					tempEdgeVertices = temp.getKey();
					if(tempEdgeVertices[0]==curPath.get(i)[k] && tempEdgeVertices[1]==curPath.get(i)[k+1])
					{
						break;
					}
				}
				tempCapacity1 = edgeCapacity.get(temp.getKey());
				if(tempCapacity1 <= minFlowEdge)
				{
					copyEdge = temp.getKey();
					minFlowEdge = tempCapacity1;
				}
			}
			saturationEdges.add(copyEdge);

			for(int i=0;i<curPath.size();i++)
			{
				edgeIterator = edgeCapacity.entrySet().iterator();
				while(edgeIterator.hasNext())
				{
					temp = edgeIterator.next();
					tempEdgeVertices = temp.getKey();
					if(tempEdgeVertices[0]==curPath.get(i)[k] && tempEdgeVertices[1]==curPath.get(i)[k+1])
					{
						break;
					}
				}
				
				Iterator<Entry<int[], Integer>> edgeFFlowIterator = edgeFFlow.entrySet().iterator();
				Iterator<Entry<int[], Integer>> edgeBFlowIterator = edgeBFlow.entrySet().iterator();
				
				Entry<int[], Integer> tempB = null;
				Entry<int[], Integer> tempF = null;
				
				int[] tempFFlowEdge;
				int[] tempBFlowEdge;
				int tempFFlow, tempBFlow;
				
				while(edgeFFlowIterator.hasNext())
				{
					tempF = edgeFFlowIterator.next();
					tempFFlowEdge = tempF.getKey();
					tempFFlow = tempF.getValue();
					if(tempFFlowEdge[0]==curPath.get(i)[k] && tempFFlowEdge[1]==curPath.get(i)[k+1])
					{
						break;
					}
				}
				
				while(edgeBFlowIterator.hasNext())
				{
					tempB = edgeBFlowIterator.next();
					tempBFlowEdge = tempB.getKey();
					tempBFlow = tempB.getValue();
					if(tempBFlowEdge[1]==curPath.get(i)[k] && tempBFlowEdge[0]==curPath.get(i)[k+1])
					{
						break;
					}
				}
				int cap = edgeCapacity.get(temp.getKey());
				int fflow = edgeFFlow.get(tempF.getKey());
				int bflow = edgeBFlow.get(tempB.getKey());
				if(cap>0)
				{
					edgeCapacity.put(temp.getKey(), cap-minFlowEdge);
					edgeFFlow.put(tempF.getKey(), fflow+minFlowEdge);
					edgeBFlow.put(tempB.getKey(), bflow+minFlowEdge);
				}
				
			}
			maxFlow+=minFlowEdge;
		}
				System.out.println("Max flow is "+maxFlow);
			
			return;
	}

}
