import java.util.Arrays;

class prims {

  public void Prim(int G[][], int V) {

    int INF = 9999999;

    int no_edge; // number of edge

    boolean[] selected = new boolean[V];

    Arrays.fill(selected, false);

    // set number of edge to 0
    no_edge = 0;

    // choose 0th vertex and make it true
    selected[0] = true;

    int cost = 0; // sum of weights of MST

    // print for edge and weight
    System.out.println("Edge : Weight");

    while (no_edge < V - 1) {
      
      int min = INF;
      int x = 0; // row number
      int y = 0; // col number
      
      for (int i = 0; i < V; i++) {
        if (selected[i] == true) {
          for (int j = 0; j < V; j++) {
            // not in selected and there is an edge
            if (!selected[j] && G[i][j] != 0) {
              if (min > G[i][j]) {
                min = G[i][j];
                x = i;
                y = j;
                
              }
            }
          }
        }
      }
      
      System.out.println(x + " - " + y + " : " + G[x][y]);
      
      cost += G[x][y]; // add weight to the sum
      selected[y] = true;
      no_edge++;
      
      
      
    }

    System.out.println("Minimum cost of MST: " + cost);
  }

  public static void main(String[] args) {
    prims g = new prims();
    
    // number of vertices in graph
    int V = 6;
    
    int[][] G = { {0,1,3,0,0,3}, {1,0,5,1,0,0}, {3,5,0,2,1,0}, {0,1,2,0,4,0} ,{0,0,1,4,0,5}, {2,0,0,0,5,0} };

    g.Prim(G, V);
    
    
  }
}
