package Chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Solution01 
{
	public static Graph createNewGraph()
	{
		// Create a graph object of size 6
		Graph graph = new Graph(6);
		
		// Create 6 Nodes
		GraphNode[] nodes = new GraphNode[6];
		
		// Store value in them
		nodes[0] = new GraphNode("a", 3);
		nodes[1] = new GraphNode("b", 0);
		nodes[2] = new GraphNode("c", 0);
		nodes[3] = new GraphNode("d", 1);
		nodes[4] = new GraphNode("e", 1);
		nodes[5] = new GraphNode("f", 0);
		
		// Connect them
		nodes[0].addNeighbor(nodes[1]);
		nodes[0].addNeighbor(nodes[2]);
		nodes[0].addNeighbor(nodes[3]);
		
		nodes[3].addNeighbor(nodes[4]);
		nodes[4].addNeighbor(nodes[5]);
		
		// This will result in a graph like this
		
		/*		  b
		 * 		  |
		 * 	c---- a
		 * 		  |
		 * 		  d ---- e ---- f
		 * */
		
		
		for (int i = 0; i < 6; i++) 
		{
			graph.addNode(nodes[i]);
		}
		
		return graph;
	}
	
	// To find if there is a path, we can follow either Standard DFS or BFS
	// Here we will use BFS.
	public static boolean search(Graph graph, GraphNode start, GraphNode end) 
	{  
		// Create a queue to add neighbor elements
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        
        // Initialize all the vertices of the graph with state = unvisited
        for (GraphNode u : graph.vertices) 
        {
            u.state = State.Unvisited;
        }
        
        // Make the start node as visiting
        start.state = State.Visiting;
        
        // Add it to queue
        queue.add(start);        
        
        GraphNode u;
        
        // Do BFS algorithm on all the elements of the queue
        while(!queue.isEmpty()) 
        {
        	// Take the first item from the queue
            u = queue.poll();
                      
            if (u != null) 
            {
            	// Get all the neighbors of the first item in the queue
	            for (GraphNode v : u.neighborNodes) 
	            {
	            	// Only consider those nodes which are unvisited
	                if (v.state == State.Unvisited) 
	                {
	                	// If this node acquired during traversal is same as the end node, return true
	                    if (v == end) 
	                    {
	                        return true;
	                    } 
	                    
	                    // Else, add it to queue. We will come to this when we are done with currently working node.
	                    else 
	                    {	                        
	                        queue.add(v);
	                    }
	                }
	            }
	            
	            // All the neighbors done, now change the state to visiting
	            u.state = State.Visited;
            }
        }
        
        // We will reach this point when the queue has become empty
        // It will mean that we would have traversed all the nodes
        // It will also mean that return true would never have executed.
        // It means, we did not find the end node.
        // So, return false
        return false;
    }
}

class Graph 
{
	// A collection of Nodes which form the vertices of this graph
	protected GraphNode vertices[];
	
	// A count of nodes in a graph	
	public int count;
	
	/* Hold all the edges of a graph -
     * Key- Name,
     * Value- List of all the neighbors for the above name
    */
    private Map<String, List<String>> edges = new HashMap<String, List<String>>();
	
	 
    // A constructor of the Graph. 
    // It initializes the array of vertices with null and sets the count of nodes to 0
	public Graph(int size) 
	{
		vertices = new GraphNode[size];
		count = 0;
    }
	
	
    // Adds the given node to the graph
    public void addNode(GraphNode x) 
    {
    	vertices[count] = x;
		count++;
    }
    
    public void addEdge(String src, String dest) 
    {
    	// Get all the neighbors of the source
        List<String> srcNeighbors = this.edges.get(src);
        
        // If the source has no neighbors list, create one and put it in map
        if (srcNeighbors == null) 
        {
        	// Create a new list
        	srcNeighbors = new ArrayList<String>();
        	
        	// Create a new edge for that source and add this edge to the edge set
            this.edges.put(src, srcNeighbors);
        }
        
        // Add the destination to the neighbor list of thi
        srcNeighbors.add(dest);
    }
}

class GraphNode 
{
	// An array of references to adjacent nodes
	protected GraphNode[] neighborNodes;
	
	// Count maintained for number of neighbors. Initially 0.
    public int currentNoOfNeighbors;
    
    // Data held by a vertex. It can be an int as well.
    private String vertex;
    
    // Variable to hold the state of the node
    public State state;
    
    
    
    /** Constructor to make a node ready. It
     *  1. Sets the vertex data
     *  2. sets the adjacent count to 0
     *  3. Initializes the adjacent array with the passed size
     * @param vertex The actual data held by a vertex
     * @param noOfNeighbors 
     */
    public GraphNode(String vertex, int noOfNeighbors) 
    {                
        neighborNodes = new GraphNode[noOfNeighbors];
        this.vertex = vertex;                
        currentNoOfNeighbors = 0;
    }
    
    /** It adds the given node to the current node
     * @param x
     */
    public void addNeighbor(GraphNode x) 
    {
    	x.state = State.Unvisited;
    	this.neighborNodes[currentNoOfNeighbors] = x;
        currentNoOfNeighbors++;        
    }       
    
}

enum State {
	Unvisited, Visited, Visiting;
}