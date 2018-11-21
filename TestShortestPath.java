import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//your class test shortest path
public class TestShortestPath
{
   public static void main(String[] args)
    {
    	int numberOfCities = 5;
    	Vertex[] cityList = initialPrompt(numberOfCities, "city");

/*
          Vertex v0 = new Vertex("Redvile");
	      Vertex v1 = new Vertex("Blueville");
	      Vertex v2 = new Vertex("Greenville");
	      Vertex v3 = new Vertex("Orangeville");
	      Vertex v4 = new Vertex("Purpleville");
*/

		cityList[0].adjacencies = new Edge[]
									{
										new Edge(cityList[1], 5),
	                             		new Edge(cityList[2], 10),
                               			new Edge(cityList[3], 8)
									};
		cityList[1].adjacencies = new Edge[]{ new Edge(cityList[0], 5),
	                             new Edge(cityList[2], 3),
	                             new Edge(cityList[4], 7) };
		cityList[2].adjacencies = new Edge[]{ new Edge(cityList[0], 10),
                               new Edge(cityList[1], 3) };
		cityList[3].adjacencies = new Edge[]{ new Edge(cityList[0], 8),
	                             new Edge(cityList[4], 2) };
		cityList[4].adjacencies = new Edge[]{ new Edge(cityList[1], 7),
                               new Edge(cityList[3], 2) };
		Vertex[] vertices = { cityList[0], cityList[1], cityList[2], cityList[3], cityList[4] };
        Dijkstra.computePaths(cityList[0]);
        for (Vertex v : vertices)
	    {
	        System.out.println("Distance to " + v + ": " + v.minDistance);
	        List<Vertex> path = Dijkstra.getShortestPathTo(v);
	        System.out.println("Path: " + path);
	    }
    }//end main

	/* Beginnings of method to allow user to input the distance between vertices

	public static Vertex[] setEdges(Vertex[] vertices)
	{
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<vertices.length-1; i++)
		{


			for (int j=0; j<vertices.length-1; j++)
			{
				ArrayList<Integer> vertList = new ArrayList<>(vertices.length);
				ArrayList<Integer> weightList = new ArrayList<>(vertices.length);

				if (i!=j)
				{
					System.out.print("Enter distance from " + vertices[i] + " to " + vertices[j] + ": ");
					int distance = scanner.nextInt();
					if (distance>0)
					{
						vertList.add(j);
						weightList.add(distance);
					}
				}

				vertList.trimToSize(); weightList.trimToSize();

				vertices[i].adjacencies = new Edge[vertList.size()]
				for (int k=0; k<vertList.size(); k++)
				{
					vertices[i].adjacencies[k] = new Edge(vertices[vertList[k]], weightList[k]);
				}

			}

			vertices[i].adjacencies = new Edge[4];

		}
	}
/*
	/**
	 * Prompts the user to enter the number of vertices and the type of thing which they are.
	 * @return Vertex[] .
	 */
	public static Vertex[] initialPrompt(int qty, String type)
	{
		Vertex[] vertices = new Vertex[qty];
		Scanner scanner = new Scanner(System.in);

		for (int i=0; i<qty; i++)
		{
			int label = i+1;
			System.out.print("Please enter " + type + " number " + label + ": ");
			vertices[i] = new Vertex(scanner.nextLine());
		}

		return vertices;

	} // end of initialPrompt()

}//end class    
